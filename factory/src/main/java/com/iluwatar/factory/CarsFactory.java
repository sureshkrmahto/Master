package com.iluwatar.factory;

/**
 * Factory of cars.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class CarsFactory {
  
  /**
   * Factory method takes as parameter a car type and initiate the appropriate class.
 *  @author Suresh Mahto
   */
public static Car getCar(CarType type) {
return type.getConstructor().get();
  }
}
