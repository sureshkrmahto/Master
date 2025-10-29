package com.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory is an object for creating other objects, it providing Providing a static method to 
 * create and return objects of varying classes, in order to hide the implementation logic 
 * and makes client code focus on usage rather then objects initialization and management.
 * 
 * <p>In this example the CarFactory is the factory class and it provides a static method to 
 * create different cars.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {
  
private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
  
  /**
   * Program main entry point.
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var car1 = CarsFactory.getCar(CarType.FORD);
var car2 = CarsFactory.getCar(CarType.FERRARI);
LOGGER.info(car1.getDescription());
LOGGER.info(car2.getDescription());
  }
}
