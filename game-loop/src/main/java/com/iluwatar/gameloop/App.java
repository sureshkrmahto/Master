package com.iluwatar.gameloop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A game loop runs continuously during gameplay. Each turn of the loop, it processes
 * user input without blocking, updates the game state, and renders the game. It tracks
 * the passage of time to control the rate of gameplay.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Each type of game loop will run for 2 seconds.
   */
  private static final int GAME_LOOP_DURATION_TIME = 2000;

  /**
   * Program entry point.
   * @param args runtime arguments
   */
  public static void main(String[] args) {

    try {
      LOGGER.info("Start frame-based game loop:");
      var frameBasedGameLoop = new FrameBasedGameLoop();
      frameBasedGameLoop.run();
      Thread.sleep(GAME_LOOP_DURATION_TIME);
      frameBasedGameLoop.stop();
      LOGGER.info("Stop frame-based game loop.");

      LOGGER.info("Start variable-step game loop:");
      var variableStepGameLoop = new VariableStepGameLoop();
      variableStepGameLoop.run();
      Thread.sleep(GAME_LOOP_DURATION_TIME);
      variableStepGameLoop.stop();
      LOGGER.info("Stop variable-step game loop.");

      LOGGER.info("Start fixed-step game loop:");
      var fixedStepGameLoop = new FixedStepGameLoop();
      fixedStepGameLoop.run();
      Thread.sleep(GAME_LOOP_DURATION_TIME);
      fixedStepGameLoop.stop();
      LOGGER.info("Stop variable-step game loop.");

    } catch (InterruptedException e) {
      LOGGER.error(e.getMessage());
    }
  }

}
