package com.data.locality.game;

import com.data.locality.game.component.manager.AiComponentManager;
import com.data.locality.game.component.manager.PhysicsComponentManager;
import com.data.locality.game.component.manager.RenderComponentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The game Entity maintains a big array of pointers . Each spin of the game loop, we need to run
 * the following:
 *
 * <p>Update the AI components.
 *
 * <p>Update the physics components for them.
 *
 * <p>Render them using their render components.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GameEntity {
private static final Logger LOGGER = LoggerFactory.getLogger(GameEntity.class);

private final AiComponentManager aiComponentManager;
private final PhysicsComponentManager physicsComponentManager;
private final RenderComponentManager renderComponentManager;

  /**
   * Init components.
 *  @author Suresh Mahto
   */
public GameEntity(int numEntities) {
LOGGER.info("Init Game with #Entity : {}", numEntities);
aiComponentManager = new AiComponentManager(numEntities);
physicsComponentManager = new PhysicsComponentManager(numEntities);
renderComponentManager = new RenderComponentManager(numEntities);
  }

  /**
   * start all component.
 *  @author Suresh Mahto
   */
public void start() {
LOGGER.info("Start Game");
aiComponentManager.start();
physicsComponentManager.start();
renderComponentManager.start();
  }

  /**
   * update all component.
 *  @author Suresh Mahto
   */
public void update() {
LOGGER.info("Update Game Component");
    // Process AI.
aiComponentManager.update();

    // update physics.
physicsComponentManager.update();

    // Draw to screen.
renderComponentManager.render();
  }

}
