package com.iluwatar.twin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GameItem is a common class which provides some common methods for game object.
 */
public abstract class GameItem {

  private static final Logger LOGGER = LoggerFactory.getLogger(GameItem.class);

  /**
   * Template method, do some common logic before draw.
   */
  public void draw() {
    LOGGER.info("draw");
    doDraw();
  }

  public abstract void doDraw();


  public abstract void click();
}
