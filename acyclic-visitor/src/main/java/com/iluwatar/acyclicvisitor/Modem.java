package com.iluwatar.acyclicvisitor;

/**
 * Modem abstract class.
 */
public abstract class Modem {
  public abstract void accept(ModemVisitor modemVisitor);
}
