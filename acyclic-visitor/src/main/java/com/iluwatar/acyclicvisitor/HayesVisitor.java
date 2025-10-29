package com.iluwatar.acyclicvisitor;

/**
 * HayesVisitor interface.
 */
public interface HayesVisitor extends ModemVisitor {
  void visit(Hayes hayes);
}
