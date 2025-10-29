package com.iluwatar.data.locality.game.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Physics Component of Game.
 */
public class PhysicsComponent implements Component {

  private static final Logger LOGGER = LoggerFactory.getLogger(PhysicsComponent.class);

  /**
   * update physics component of game.
   */
  @Override
  public void update() {
    LOGGER.info("Update physics component of game");
  }

  @Override
  public void render() {
    // do nothing
  }
}
