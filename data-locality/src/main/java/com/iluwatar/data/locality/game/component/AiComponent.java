package com.iluwatar.data.locality.game.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of AI component for Game.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AiComponent implements Component {

private static final Logger LOGGER = LoggerFactory.getLogger(AiComponent.class);

  /**
   * Update ai component.
 *  @author Suresh Mahto
   */
  @Override
public void update() {
LOGGER.info("update AI component");
  }

@Override
public void render() {
    // Do Nothing.
  }
}
