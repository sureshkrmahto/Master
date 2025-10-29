package com.iluwatar.factory.method;

/**
 * ElfWeapon.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ElfWeapon implements Weapon {

  private final WeaponType weaponType;

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
