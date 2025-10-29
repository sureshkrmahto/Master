package com.iluwatar.bridge;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Test;

/**
 * Tests for hammer
 */
class HammerTest extends WeaponTest {

  /**
   * Invoke all possible actions on the weapon and check if the actions are executed on the actual
   * underlying weapon implementation.
   */
  @Test
  void testHammer() {
    final var hammer = spy(new Hammer(mock(FlyingEnchantment.class)));
    testBasicWeaponActions(hammer);
  }
}