package com.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Customer attempts to repeatedly take Fruit from the FruitShop by taking Fruit from FruitBowl
 * instances.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Customer extends Thread {

private static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

  /**
   * Name of the Customer.
 *  @author Suresh Mahto
   */
private final String name;

  /**
   * The FruitShop he is using.
 *  @author Suresh Mahto
   */
private final FruitShop fruitShop;

  /**
   * Their bowl of Fruit.
 *  @author Suresh Mahto
   */
private final FruitBowl fruitBowl;

  /**
   * Customer constructor.
 *  @author Suresh Mahto
   */
public Customer(String name, FruitShop fruitShop) {
this.name = name;
this.fruitShop = fruitShop;
this.fruitBowl = new FruitBowl();
  }

  /**
   * The Customer repeatedly takes Fruit from the FruitShop until no Fruit remains.
 *  @author Suresh Mahto
   */
public void run() {

while (fruitShop.countFruit() > 0) {
var bowl = fruitShop.takeBowl();
if (bowl != null) {
var fruit = bowl.take();
if (fruit != null) {
LOGGER.info("{} took an {}", name, fruit);
fruitBowl.put(fruit);
fruitShop.returnBowl(bowl);
        }
      }
    }

LOGGER.info("{} took {}", name, fruitBowl);

  }

}
