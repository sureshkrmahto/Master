package com.iluwatar.gameloop;

/**
 * The variable-step game loop chooses a time step to advance based on how much
 * real time passed since the last frame. The longer the frame takes, the bigger
 * steps the game takes. It always keeps up with real time because it will take
 * bigger and bigger steps to get there.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class VariableStepGameLoop extends GameLoop {

  @Override
  protected void processGameLoop() {
    var lastFrameTime = System.currentTimeMillis();
    while (isGameRunning()) {
      processInput();
      var currentFrameTime = System.currentTimeMillis();
      var elapsedTime = currentFrameTime - lastFrameTime;
      update(elapsedTime);
      lastFrameTime = currentFrameTime;
      render();
    }
  }

  protected void update(Long elapsedTime) {
    controller.moveBullet(0.5f * elapsedTime / 1000);
  }

}
