package com.iluwatar.updatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This pattern simulate a collection of independent objects by telling each to
 * process one frame of behavior at a time. The game world maintains a collection
 * of objects. Each object implements an update method that simulates one frame of
 * the object’s behavior. Each frame, the game updates every object in the collection.
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  private static final int GAME_RUNNING_TIME = 2000;

  /**
   * Program entry point.
   * @param args runtime arguments
   */
  public static void main(String[] args) {
    try {
      var world = new World();
      var skeleton1 = new Skeleton(1, 10);
      var skeleton2 = new Skeleton(2, 70);
      var statue = new Statue(3, 20);
      world.addEntity(skeleton1);
      world.addEntity(skeleton2);
      world.addEntity(statue);
      world.run();
      Thread.sleep(GAME_RUNNING_TIME);
      world.stop();
    } catch (InterruptedException e) {
      LOGGER.error(e.getMessage());
    }
  }
}
