package com.data.locality.game.component.manager;

import com.data.locality.game.component.Component;
import com.data.locality.game.component.RenderComponent;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Render component manager for Game.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class RenderComponentManager {

private static final Logger LOGGER = LoggerFactory.getLogger(RenderComponentManager.class);

private static final int MAX_ENTITIES = 10000;

private final int numEntities;

private final Component[] renderComponents = new RenderComponent[MAX_ENTITIES];

public RenderComponentManager(int numEntities) {
this.numEntities = numEntities;
  }

  /**
   * Start render component.
 *  @author Suresh Mahto
   */
public void start() {
LOGGER.info("Start Render Game Component ");
IntStream.range(0, numEntities).forEach(i -> renderComponents[i] = new RenderComponent());
  }


  /**
   * render component.
 *  @author Suresh Mahto
   */
public void render() {
LOGGER.info("Update Render Game Component ");
    // Process Render.
IntStream.range(0, numEntities)
        .filter(i -> renderComponents.length > i && renderComponents[i] != null)
        .forEach(i -> renderComponents[i].render());
  }
}
