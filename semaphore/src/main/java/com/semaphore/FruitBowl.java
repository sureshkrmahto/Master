package com.semaphore;

import java.util.ArrayList;
import java.util.List;

/**
 * A FruitBowl contains Fruit.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class FruitBowl {

private final List<Fruit> fruit = new ArrayList<>();

  /**
   * Returns the amount of fruits left in bowl.
   *
   * @return The amount of Fruit left in the bowl.
 *  @author Suresh Mahto
   */
public int countFruit() {
return fruit.size();
  }

  /**
   * Put an item of Fruit into the bowl.
   *
   * @param f fruit
 *  @author Suresh Mahto
   */
public void put(Fruit f) {
fruit.add(f);
  }

  /**
   * Take an item of Fruit out of the bowl.
   *
   * @return The Fruit taken out of the bowl, or null if empty.
 *  @author Suresh Mahto
   */
public Fruit take() {
if (fruit.isEmpty()) {
return null;
    } else {
return fruit.remove(0);
    }
  }

  /**
   * toString method.
 *  @author Suresh Mahto
   */
public String toString() {
var apples = 0;
var oranges = 0;
var lemons = 0;

for (var f : fruit) {
switch (f.getType()) {
case APPLE:
apples++;
break;
case ORANGE:
oranges++;
break;
case LEMON:
lemons++;
break;
default:
      }
    }

return apples + " Apples, " + oranges + " Oranges, and " + lemons + " Lemons";
  }
}
