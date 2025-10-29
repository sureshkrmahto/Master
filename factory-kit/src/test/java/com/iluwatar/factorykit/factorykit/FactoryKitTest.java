package com.iluwatar.factorykit.factorykit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.factorykit.Axe;
import com.iluwatar.factorykit.Spear;
import com.iluwatar.factorykit.Sword;
import com.iluwatar.factorykit.Weapon;
import com.iluwatar.factorykit.WeaponFactory;
import com.iluwatar.factorykit.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Factory Kit Pattern
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class FactoryKitTest {

private WeaponFactory factory;

@BeforeEach
public void init() {
factory = WeaponFactory.factory(builder -> {
builder.add(WeaponType.SPEAR, Spear::new);
builder.add(WeaponType.AXE, Axe::new);
builder.add(WeaponType.SWORD, Sword::new);
    });
  }

  /**
   * Testing {@link WeaponFactory} to produce a SPEAR asserting that the Weapon is an instance of
   * {@link Spear}
 *  @author Suresh Mahto
   */
  @Test
public void testSpearWeapon() {
var weapon = factory.create(WeaponType.SPEAR);
verifyWeapon(weapon, Spear.class);
  }

  /**
   * Testing {@link WeaponFactory} to produce a AXE asserting that the Weapon is an instance of
   * {@link Axe}
 *  @author Suresh Mahto
   */
  @Test
public void testAxeWeapon() {
var weapon = factory.create(WeaponType.AXE);
verifyWeapon(weapon, Axe.class);
  }


  /**
   * Testing {@link WeaponFactory} to produce a SWORD asserting that the Weapon is an instance of
   * {@link Sword}
 *  @author Suresh Mahto
   */
  @Test
public void testWeapon() {
var weapon = factory.create(WeaponType.SWORD);
verifyWeapon(weapon, Sword.class);
  }

  /**
   * This method asserts that the weapon object that is passed is an instance of the clazz
   *
   * @param weapon weapon object which is to be verified
   * @param clazz  expected class of the weapon
 *  @author Suresh Mahto
   */
private void verifyWeapon(Weapon weapon, Class<?> clazz) {
assertTrue(clazz.isInstance(weapon), "Weapon must be an object of: " + clazz.getName());
  }
}
