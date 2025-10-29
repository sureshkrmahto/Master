package com.subclasssandbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The subclass sandbox pattern describes a basic idea, while not having a lot
 * of detailed mechanics. You will need the pattern when you have several similar
 * subclasses. If you have to make a tiny change, then change the base class,
 * while all subclasses shouldn't have to be touched. So the base class has to be
 * able to provide all of the operations a derived class needs to perform.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Entry point of the main program.
   * @param args Program runtime arguments.
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
LOGGER.info("Use superpower: sky launch");
var skyLaunch = new SkyLaunch();
skyLaunch.activate();
LOGGER.info("Use superpower: ground dive");
var groundDive = new GroundDive();
groundDive.activate();
  }

}
