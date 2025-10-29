package com.iluwatar.gameloop;

/**
 * For fixed-step game loop, a certain amount of real time has elapsed since the
 * last turn of the game loop. This is how much game time need to be simulated for
 * the game’s “now” to catch up with the player’s.
 */
public class FixedStepGameLoop extends GameLoop {

  /**
   * 20 ms per frame = 50 FPS.
   */
  private static final long MS_PER_FRAME = 20;

  @Override
  protected void processGameLoop() {
    var previousTime = System.currentTimeMillis();
    var lag = 0L;
    while (isGameRunning()) {
      var currentTime = System.currentTimeMillis();
      var elapsedTime = currentTime - previousTime;
      previousTime = currentTime;
      lag += elapsedTime;

      processInput();

      while (lag >= MS_PER_FRAME) {
        update();
        lag -= MS_PER_FRAME;
      }

      render();
    }
  }

  protected void update() {
    controller.moveBullet(0.5f * MS_PER_FRAME / 1000);
  }
}
