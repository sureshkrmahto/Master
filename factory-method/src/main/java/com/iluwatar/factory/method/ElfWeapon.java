package com.iluwatar.factory.method;

/**
 * Concrete product representing an Elven-made {@link Weapon}.
 */
public class ElfWeapon implements Weapon {

  private final WeaponType weaponType;

  /**
   * Creates a new Elven weapon of the given type.
   *
   * @param weaponType type of weapon
   */
  public ElfWeapon(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  @Override
  public String toString() {
    return "Elven " + weaponType;
  }

  @Override
  public WeaponType getWeaponType() {
    return weaponType;
  }
}
