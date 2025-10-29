package com.delegation.simple;

import com.delegation.simple.printers.CanonPrinter;
import com.delegation.simple.printers.EpsonPrinter;
import com.delegation.simple.printers.HpPrinter;

/**
 * Interface that both the Controller and the Delegate will implement.
 *
 * @see CanonPrinter
 * @see EpsonPrinter
 * @see HpPrinter
 *  @author Suresh Mahto
 */
public interface Printer {

  /**
   * Method that takes a String to print to the screen. This will be implemented on both the
   * controller and the delegate allowing the controller to call the same method on the delegate
   * class.
   *
   * @param message to be printed to the screen
*/
void print(final String message);
}
