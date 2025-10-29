package com.iluwatar.delegation.simple.printers;

import com.iluwatar.delegation.simple.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Specialised Implementation of {@link Printer} for a HP Printer, in this case the message to be
 * printed is appended to "HP Printer : ".
 *
 * @see Printer
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class HpPrinter implements Printer {

private static final Logger LOGGER = LoggerFactory.getLogger(HpPrinter.class);

  /**
   * {@inheritDoc}
 *  @author Suresh Mahto
   */
  @Override
public void print(String message) {
LOGGER.info("HP Printer : {}", message);
  }

}
