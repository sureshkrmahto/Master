package com.iluwatar.data.locality.game.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of Render Component of Game.
 */
public class RenderComponent implements Component {

  private static final Logger LOGGER = LoggerFactory.getLogger(RenderComponent.class);

  @Override
  public void update() {
    // do nothing
  }

  /**
   * render.
   */
  @Override
  public void render() {
    LOGGER.info("Render Component");
  }
}
