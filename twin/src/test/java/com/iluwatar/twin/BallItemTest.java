package com.iluwatar.twin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Suresh Mahto
 */
public class BallItemTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  @Test
  public void testClick() {
    final var ballThread = mock(BallThread.class);
    final var ballItem = new BallItem();
    ballItem.setTwin(ballThread);

    final var inOrder = inOrder(ballThread);

    IntStream.range(0, 10).forEach(i -> {
      ballItem.click();
      inOrder.verify(ballThread).suspendMe();
      ballItem.click();
      inOrder.verify(ballThread).resumeMe();
    });

    inOrder.verifyNoMoreInteractions();
  }

  @Test
  public void testDoDraw() {
    final var ballItem = new BallItem();
    final var ballThread = mock(BallThread.class);
    ballItem.setTwin(ballThread);

    ballItem.draw();
    assertTrue(appender.logContains("draw"));
    assertTrue(appender.logContains("doDraw"));

    verifyNoMoreInteractions(ballThread);
    assertEquals(2, appender.getLogSize());
  }

  @Test
  public void testMove() {
    final var ballItem = new BallItem();
    final var ballThread = mock(BallThread.class);
    ballItem.setTwin(ballThread);

    ballItem.move();
    assertTrue(appender.logContains("move"));

    verifyNoMoreInteractions(ballThread);
    assertEquals(1, appender.getLogSize());
  }

  /**
   * Logging Appender Implementation
   */
  public class InMemoryAppender extends AppenderBase<ILoggingEvent> {
    private final List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender() {
      ((Logger) LoggerFactory.getLogger("root")).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public boolean logContains(String message) {
      return log.stream().anyMatch(event -> event.getMessage().equals(message));
    }

    public int getLogSize() {
      return log.size();
    }
  }

}
