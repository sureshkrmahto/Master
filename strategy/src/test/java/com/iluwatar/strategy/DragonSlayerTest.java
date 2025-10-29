package com.iluwatar.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class DragonSlayerTest {

  /**
   * Verify if the dragon slayer uses the strategy during battle.
   */
  @Test
  public void testGoToBattle() {
    final var strategy = mock(DragonSlayingStrategy.class);
    final var dragonSlayer = new DragonSlayer(strategy);

    dragonSlayer.goToBattle();
    verify(strategy).execute();
    verifyNoMoreInteractions(strategy);
  }

  /**
   * Verify if the dragon slayer uses the new strategy during battle after a change of strategy.
   */
  @Test
  public void testChangeStrategy() {
    final var initialStrategy = mock(DragonSlayingStrategy.class);
    final var dragonSlayer = new DragonSlayer(initialStrategy);

    dragonSlayer.goToBattle();
    verify(initialStrategy).execute();

    final var newStrategy = mock(DragonSlayingStrategy.class);
    dragonSlayer.changeStrategy(newStrategy);

    dragonSlayer.goToBattle();
    verify(newStrategy).execute();

    verifyNoMoreInteractions(initialStrategy, newStrategy);
  }
}