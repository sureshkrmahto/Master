package com.iluwatar.collectionpipeline;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In imperative-style programming, it is common to use for and while loops for most kinds of data
 * processing. Function composition is a simple technique that lets you sequence modular functions
 * to create more complex operations. When you run data through the sequence, you have a collection
 * pipeline. Together, the Function Composition and Collection Pipeline patterns enable you to
 * create sophisticated programs where data flow from upstream to downstream and is passed through a
 * series of transformations.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var cars = CarFactory.createCars();

var modelsImperative = ImperativeProgramming.getModelsAfter2000(cars);
LOGGER.info(modelsImperative.toString());

var modelsFunctional = FunctionalProgramming.getModelsAfter2000(cars);
LOGGER.info(modelsFunctional.toString());

var groupingByCategoryImperative = ImperativeProgramming.getGroupingOfCarsByCategory(cars);
LOGGER.info(groupingByCategoryImperative.toString());

var groupingByCategoryFunctional = FunctionalProgramming.getGroupingOfCarsByCategory(cars);
LOGGER.info(groupingByCategoryFunctional.toString());

var john = new Person(cars);

var sedansOwnedImperative = ImperativeProgramming.getSedanCarsOwnedSortedByDate(List.of(john));
LOGGER.info(sedansOwnedImperative.toString());

var sedansOwnedFunctional = FunctionalProgramming.getSedanCarsOwnedSortedByDate(List.of(john));
LOGGER.info(sedansOwnedFunctional.toString());
  }
}
