package com.iluwatar.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Melee strategy.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class MeleeStrategy implements DragonSlayingStrategy {

  private static final Logger LOGGER = LoggerFactory.getLogger(MeleeStrategy.class);

  @Override
  public void execute() {
    LOGGER.info("With your Excalibur you sever the dragon's head!");
  }
}
