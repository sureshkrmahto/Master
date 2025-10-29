package com.iluwatar.templatemethod;

/**
 * Halfling thief uses {@link StealingMethod} to steal.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class HalflingThief {

private StealingMethod method;

public HalflingThief(StealingMethod method) {
this.method = method;
  }

public void steal() {
method.steal();
  }

public void changeMethod(StealingMethod method) {
this.method = method;
  }
}
