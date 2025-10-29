package com.iluwatar.poison.pill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 *
 * @author Suresh Mahto
 */
public class ProducerTest {

  @Test
  public void testSend() throws Exception {
    final var publishPoint = mock(MqPublishPoint.class);
    final var producer = new Producer("producer", publishPoint);
    verifyZeroInteractions(publishPoint);

    producer.send("Hello!");

    final var messageCaptor = ArgumentCaptor.forClass(Message.class);
    verify(publishPoint).put(messageCaptor.capture());

    final var message = messageCaptor.getValue();
    assertNotNull(message);
    assertEquals("producer", message.getHeader(Message.Headers.SENDER));
    assertNotNull(message.getHeader(Message.Headers.DATE));
    assertEquals("Hello!", message.getBody());

    verifyNoMoreInteractions(publishPoint);
  }

  @Test
  public void testStop() throws Exception {
    final var publishPoint = mock(MqPublishPoint.class);
    final var producer = new Producer("producer", publishPoint);
    verifyZeroInteractions(publishPoint);

    producer.stop();
    verify(publishPoint).put(eq(Message.POISON_PILL));

    try {
      producer.send("Hello!");
      fail("Expected 'IllegalStateException' at this point, since the producer has stopped!");
    } catch (IllegalStateException e) {
      assertNotNull(e);
      assertNotNull(e.getMessage());
      assertEquals("Producer Hello! was stopped and fail to deliver requested message [producer].",
          e.getMessage());
    }

    verifyNoMoreInteractions(publishPoint);
  }

}
