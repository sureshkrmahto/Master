package com.iluwatar.semaphore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Test taking from and putting Fruit into a FruitBowl
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class FruitBowlTest {

@Test
public void fruitBowlTest() {
var fbowl = new FruitBowl();

assertEquals(0, fbowl.countFruit());

for (var i = 1; i <= 10; i++) {
fbowl.put(new Fruit(Fruit.FruitType.LEMON));
assertEquals(i, fbowl.countFruit());
    }

for (var i = 9; i >= 0; i--) {
assertNotNull(fbowl.take());
assertEquals(i, fbowl.countFruit());
    }

assertNull(fbowl.take());
  }
}
