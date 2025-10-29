package com.iluwatar.strategy;

/**
 * Context that uses a {@link DragonSlayingStrategy} to slay dragons.
 *
 * <p>The chosen strategy can be swapped at runtime via
 * {@link #changeStrategy(DragonSlayingStrategy)} enabling the same client to
 * vary its behavior without changing its own code.</p>
 */
public class DragonSlayer {

  private DragonSlayingStrategy strategy;

  /**
   * Creates a new dragonslayer with the given strategy.
   *
   * @param strategy initial strategy to use
   */
  public DragonSlayer(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Replaces the current dragon-slaying strategy.
   *
   * @param strategy strategy to use on subsequent battles
   */
  public void changeStrategy(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Executes the current {@link DragonSlayingStrategy}.
   */
  public void goToBattle() {
    strategy.execute();
  }
}
