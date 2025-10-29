package com.iluwatar.visitor;

import java.util.Arrays;

/**
 * Interface for the nodes in hierarchy.
 */
public abstract class Unit {

  private final Unit[] children;

  public Unit(Unit... children) {
    this.children = children;
  }

  /**
   * Accept visitor.
   */
  public void accept(UnitVisitor visitor) {
    Arrays.stream(children).forEach(child -> child.accept(visitor));
  }
}
