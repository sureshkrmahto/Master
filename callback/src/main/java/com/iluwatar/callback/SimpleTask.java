package com.iluwatar.callback;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

/**
 * Implementation of task that need to be executed.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public final class SimpleTask extends Task {

  private static final Logger LOGGER = getLogger(SimpleTask.class);

  @Override
  public void execute() {
    LOGGER.info("Perform some important activity and after call the"
        + " callback method.");
  }
}
