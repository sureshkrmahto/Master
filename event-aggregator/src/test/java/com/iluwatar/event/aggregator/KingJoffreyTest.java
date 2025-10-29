package com.iluwatar.event.aggregator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
/**
 * @author Suresh Mahto
 */
public class KingJoffreyTest {

  private InMemoryAppender appender;


/**

 * @author Suresh Mahto

 */
  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender(KingJoffrey.class);
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * Test if {@link KingJoffrey} tells us what event he received
   */
  @Test
  public void testOnEvent() {
    final var kingJoffrey = new KingJoffrey();

    IntStream.range(0, Event.values().length).forEach(i -> {
      assertEquals(i, appender.getLogSize());
      var event = Event.values()[i];
      kingJoffrey.onEvent(event);
      final var expectedMessage = "Received event from the King's Hand: " + event.toString();
      assertEquals(expectedMessage, appender.getLastMessage());
      assertEquals(i + 1, appender.getLogSize());
    });

  }

/**
 * @author Suresh Mahto
 */
  private class InMemoryAppender extends AppenderBase<ILoggingEvent> {
    private final List<ILoggingEvent> log = new LinkedList<>();

    public InMemoryAppender(Class<?> clazz) {
      ((Logger) LoggerFactory.getLogger(clazz)).addAppender(this);
      start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
      log.add(eventObject);
    }

    public String getLastMessage() {
      return log.get(log.size() - 1).getFormattedMessage();
    }

    public int getLogSize() {
      return log.size();
    }
  }

}
