package com.factory.method;

/**
 * Concrete product representing an Orc-made {@link Weapon}.
 *  @author Suresh Mahto
 */
public class OrcWeapon implements Weapon {

private final WeaponType weaponType;

  /**
   * Creates a new Orc weapon of the given type.
   *
   * @param weaponType type of weapon
 *  @author Suresh Mahto
   */
public OrcWeapon(WeaponType weaponType) {
this.weaponType = weaponType;
  }

@Override
public String toString() {
return "Orcish " + weaponType;
  }

@Override
public WeaponType getWeaponType() {
return weaponType;
  }
}
