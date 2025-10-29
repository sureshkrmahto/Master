package com.iluwatar.visitor;

import java.util.Arrays;

/**
 * Interface for the nodes in hierarchy.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Unit {

private final Unit[] children;

public Unit(Unit... children) {
this.children = children;
  }

  /**
   * Accept visitor.
 *  @author Suresh Mahto
   */
public void accept(UnitVisitor visitor) {
Arrays.stream(children).forEach(child -> child.accept(visitor));
  }
}
