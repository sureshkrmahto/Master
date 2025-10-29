package com.iluwatar.factory.method;

/**
 * Concrete product representing an Orc-made {@link Weapon}.
 */
public class OrcWeapon implements Weapon {

  private final WeaponType weaponType;

  /**
   * Creates a new Orc weapon of the given type.
   *
   * @param weaponType type of weapon
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
