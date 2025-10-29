package com.iluwatar.strategy;

/**
 * DragonSlayer uses different strategies to slay the dragon.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class DragonSlayer {

  private DragonSlayingStrategy strategy;

  public DragonSlayer(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void changeStrategy(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void goToBattle() {
    strategy.execute();
  }
}
