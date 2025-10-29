package com.iluwatar.model.view.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.LinkedList;
import java.util.List;
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
public class GiantViewTest {

  private InMemoryAppender appender;


/**

 * @author Suresh Mahto

 */
  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender(GiantView.class);
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * Verify if the {@link GiantView} does what it has to do: Print the {@link GiantModel} to the
   * standard out stream, nothing more, nothing less.
   */
  @Test
  public void testDisplayGiant() {
    final var view = new GiantView();

    final var model = mock(GiantModel.class);
    view.displayGiant(model);

    assertEquals(model.toString(), appender.getLastMessage());
    assertEquals(1, appender.getLogSize());
  }

  /**
   * Logging Appender Implementation
   */
/**
 * @author Suresh Mahto
 */
  public static class InMemoryAppender extends AppenderBase<ILoggingEvent> {
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
      return log.get(log.size() - 1).getMessage();
    }

    public int getLogSize() {
      return log.size();
    }
  }
}
