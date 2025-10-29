package com.acyclicvisitor;

/**
 * HayesVisitor interface.
 *  @author Suresh Mahto
 */
public interface HayesVisitor extends ModemVisitor {
void visit(Hayes hayes);
}
