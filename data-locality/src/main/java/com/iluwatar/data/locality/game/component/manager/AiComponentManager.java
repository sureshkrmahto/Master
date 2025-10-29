package com.iluwatar.data.locality.game.component.manager;

import com.iluwatar.data.locality.game.component.AiComponent;
import com.iluwatar.data.locality.game.component.Component;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AI component manager for Game.
 */
public class AiComponentManager {

  private static final Logger LOGGER = LoggerFactory.getLogger(AiComponentManager.class);

  private static final int MAX_ENTITIES = 10000;

  private final int numEntities;

  private final Component[] aiComponents = new AiComponent[MAX_ENTITIES];

  public AiComponentManager(int numEntities) {
    this.numEntities = numEntities;
  }

  /**
   * start AI component of Game.
   */
  public void start() {
    LOGGER.info("Start AI Game Component");
    IntStream.range(0, numEntities).forEach(i -> aiComponents[i] = new AiComponent());
  }

  /**
   * Update AI component of Game.
   */
  public void update() {
    LOGGER.info("Update AI Game Component");
    IntStream.range(0, numEntities)
        .filter(i -> aiComponents.length > i && aiComponents[i] != null)
        .forEach(i -> aiComponents[i].update());
  }
}
