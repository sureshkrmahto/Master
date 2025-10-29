package com.iluwatar.delegation.simple.printers;

import com.iluwatar.delegation.simple.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Specialised Implementation of {@link Printer} for a Canon Printer, in this case the message to be
 * printed is appended to "Canon Printer : ".
 *
 * @see Printer
 */
public class CanonPrinter implements Printer {

  private static final Logger LOGGER = LoggerFactory.getLogger(CanonPrinter.class);

  /**
   * {@inheritDoc}
   */
  @Override
  public void print(String message) {
    LOGGER.info("Canon Printer : {}", message);
  }

}
