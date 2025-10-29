package com.updatemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The game world class. Maintain all the objects existed in the game frames.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class World {

private static final Logger LOGGER = LoggerFactory.getLogger(World.class);

protected List<Entity> entities;

protected volatile boolean isRunning;

public World() {
entities = new ArrayList<>();
isRunning = false;
  }

  /**
   * Main game loop. This loop will always run until the game is over. For
   * each loop it will process user input, update internal status, and render
   * the next frames. For more detail please refer to the game-loop pattern.
 *  @author Suresh Mahto
   */
private void gameLoop() {
while (isRunning) {
processInput();
update();
render();
    }
  }

  /**
   * Handle any user input that has happened since the last call. In order to
   * simulate the situation in real-life game, here we add a random time lag.
   * The time lag ranges from 50 ms to 250 ms.
 *  @author Suresh Mahto
   */
private void processInput() {
try {
int lag = new Random().nextInt(200) + 50;
Thread.sleep(lag);
    } catch (InterruptedException e) {
LOGGER.error(e.getMessage());
    }
  }

  /**
   * Update internal status. The update method pattern invoke udpate method for
   * each entity in the game.
 *  @author Suresh Mahto
   */
private void update() {
for (var entity : entities) {
entity.update();
    }
  }

  /**
   * Render the next frame. Here we do nothing since it is not related to the
   * pattern.
 *  @author Suresh Mahto
   */
private void render() {
    // Does Nothing
  }

  /**
   * Run game loop.
 *  @author Suresh Mahto
   */
public void run() {
LOGGER.info("Start game.");
isRunning = true;
var thread = new Thread(this::gameLoop);
thread.start();
  }

  /**
   * Stop game loop.
 *  @author Suresh Mahto
   */
public void stop() {
LOGGER.info("Stop game.");
isRunning = false;
  }

public void addEntity(Entity entity) {
entities.add(entity);
  }

}
