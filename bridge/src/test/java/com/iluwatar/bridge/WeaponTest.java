package com.iluwatar.bridge;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Base class for weapon tests
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
abstract class WeaponTest {

  /**
   * Invoke the basic actions of the given weapon, and test if the underlying enchantment
   * implementation is invoked
   */
  final void testBasicWeaponActions(final Weapon weapon) {
    assertNotNull(weapon);
    var enchantment = weapon.getEnchantment();
    assertNotNull(enchantment);
    assertNotNull(weapon.getEnchantment());

    weapon.swing();
    verify(enchantment).apply();
    verifyNoMoreInteractions(enchantment);

    weapon.wield();
    verify(enchantment).onActivate();
    verifyNoMoreInteractions(enchantment);

    weapon.unwield();
    verify(enchantment).onDeactivate();
    verifyNoMoreInteractions(enchantment);

  }
}
