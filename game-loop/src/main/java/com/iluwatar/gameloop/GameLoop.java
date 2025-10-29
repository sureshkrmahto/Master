package com.iluwatar.gameloop;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for GameLoop implementation class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class GameLoop {

protected final Logger logger = LoggerFactory.getLogger(this.getClass());

protected volatile GameStatus status;

protected final GameController controller;

private Thread gameThread;

  /**
   * Initialize game status to be stopped.
 *  @author Suresh Mahto
   */
public GameLoop() {
controller = new GameController();
status = GameStatus.STOPPED;
  }

  /**
   * Run game loop.
 *  @author Suresh Mahto
   */
public void run() {
status = GameStatus.RUNNING;
gameThread = new Thread(this::processGameLoop);
gameThread.start();
  }

  /**
   * Stop game loop.
 *  @author Suresh Mahto
   */
public void stop() {
status = GameStatus.STOPPED;
  }

  /**
   * Check if game is running or not.
   *
   * @return {@code true} if the game is running.
 *  @author Suresh Mahto
   */
public boolean isGameRunning() {
return status == GameStatus.RUNNING;
  }

  /**
   * Handle any user input that has happened since the last call. In order to
   * simulate the situation in real-life game, here we add a random time lag.
   * The time lag ranges from 50 ms to 250 ms.
 *  @author Suresh Mahto
   */
protected void processInput() {
try {
var lag = new Random().nextInt(200) + 50;
Thread.sleep(lag);
    } catch (InterruptedException e) {
logger.error(e.getMessage());
    }
  }

  /**
   * Render game frames to screen. Here we print bullet position to simulate
   * this process.
 *  @author Suresh Mahto
   */
protected void render() {
var position = controller.getBulletPosition();
logger.info("Current bullet position: " + position);
  }

  /**
   * execute game loop logic.
 *  @author Suresh Mahto
   */
protected abstract void processGameLoop();

}
