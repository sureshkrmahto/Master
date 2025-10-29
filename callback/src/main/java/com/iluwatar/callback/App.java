package com.iluwatar.callback;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

/**
 * Callback pattern is more native for functional languages where functions are treated as
 * first-class citizens. Prior to Java 8 callbacks can be simulated using simple (alike command)
 * interfaces.
 */
public final class App {

  private static final Logger LOGGER = getLogger(App.class);

  private App() {
  }

  /**
   * Program entry point.
   */
  public static void main(final String[] args) {
    var task = new SimpleTask();
    task.executeWith(() -> LOGGER.info("I'm done now."));
  }
}
