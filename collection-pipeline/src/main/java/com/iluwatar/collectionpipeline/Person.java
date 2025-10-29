package com.iluwatar.collectionpipeline;

import java.util.List;

/**
 * A Person class that has the list of cars that the person owns and use.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Person {
  private final List<Car> cars;

  /**
   * Constructor to create an instance of person.
   *
   * @param cars the list of cars owned
   */
  public Person(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }
}