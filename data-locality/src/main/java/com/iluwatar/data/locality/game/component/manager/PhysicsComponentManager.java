package com.iluwatar.data.locality.game.component.manager;

import com.iluwatar.data.locality.game.component.Component;
import com.iluwatar.data.locality.game.component.PhysicsComponent;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Physics component Manager for Game.
 */
public class PhysicsComponentManager {

  private static final Logger LOGGER = LoggerFactory.getLogger(PhysicsComponentManager.class);

  private static final int MAX_ENTITIES = 10000;

  private final int numEntities;

  private final Component[] physicsComponents = new PhysicsComponent[MAX_ENTITIES];

  public PhysicsComponentManager(int numEntities) {
    this.numEntities = numEntities;
  }

  /**
   * Start physics component of Game.
   */
  public void start() {
    LOGGER.info("Start Physics Game Component ");
    IntStream.range(0, numEntities).forEach(i -> physicsComponents[i] = new PhysicsComponent());
  }


  /**
   * Update physics component of Game.
   */
  public void update() {
    LOGGER.info("Update Physics Game Component ");
    // Process physics.
    IntStream.range(0, numEntities)
        .filter(i -> physicsComponents.length > i && physicsComponents[i] != null)
        .forEach(i -> physicsComponents[i].update());
  }
}
