package com.iluwatar.semaphore;

/**
 * A Semaphore mediates access by a group of threads to a pool of resources.
 *
 * <p>In this example a group of customers are taking fruit from a fruit shop. There is a bowl each
 * of apples, oranges and lemons. Only one customer can access a bowl simultaneously. A Semaphore is
 * used to indicate how many resources are currently available and must be acquired in order for a
 * bowl to be given to a customer. Customers continually try to take fruit until there is no fruit
 * left in the shop.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

  /**
   * main method.
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var shop = new FruitShop();
new Customer("Peter", shop).start();
new Customer("Paul", shop).start();
new Customer("Mary", shop).start();
new Customer("John", shop).start();
new Customer("Ringo", shop).start();
new Customer("George", shop).start();
  }

}
