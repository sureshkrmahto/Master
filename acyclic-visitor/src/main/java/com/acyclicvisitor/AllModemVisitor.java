package com.acyclicvisitor;

/**
 * All ModemVisitor interface extends all visitor interfaces. This interface provides ease of use
 * when a visitor needs to visit all modem types.
 *  @author Suresh Mahto
 */
public interface AllModemVisitor extends ZoomVisitor, HayesVisitor {

}
