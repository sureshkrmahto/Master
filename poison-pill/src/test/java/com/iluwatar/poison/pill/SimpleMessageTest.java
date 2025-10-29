package com.iluwatar.poison.pill;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class SimpleMessageTest {

  @Test
  public void testGetHeaders() {
    final var message = new SimpleMessage();
    assertNotNull(message.getHeaders());
    assertTrue(message.getHeaders().isEmpty());

    final var senderName = "test";
    message.addHeader(Message.Headers.SENDER, senderName);
    assertNotNull(message.getHeaders());
    assertFalse(message.getHeaders().isEmpty());
    assertEquals(senderName, message.getHeaders().get(Message.Headers.SENDER));
  }

  @Test
  public void testUnModifiableHeaders() {
    final var message = new SimpleMessage();
    final var headers = message.getHeaders();
    assertThrows(UnsupportedOperationException.class, () -> {
      headers.put(Message.Headers.SENDER, "test");
    });
  }


}