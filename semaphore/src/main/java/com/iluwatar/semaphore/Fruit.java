package com.iluwatar.semaphore;

/**
 * Fruit is a resource stored in a FruitBowl.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Fruit {

  /**
   * Enumeration of Fruit Types.
 *  @author Suresh Mahto
   */
public enum FruitType {
ORANGE, APPLE, LEMON
  }

private final FruitType type;

public Fruit(FruitType type) {
this.type = type;
  }

public FruitType getType() {
return type;
  }

  /**
   * toString method.
 *  @author Suresh Mahto
   */
public String toString() {
switch (type) {
case ORANGE:
return "Orange";
case APPLE:
return "Apple";
case LEMON:
return "Lemon";
default:
return "";
    }
  }

}
