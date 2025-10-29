package com.iluwatar.strategy;

/**
 * Strategy interface encapsulating a dragon-slaying algorithm.
 */
@FunctionalInterface
public interface DragonSlayingStrategy {

  /**
   * Executes the strategy-specific dragon slaying algorithm.
   */
void execute();

}
