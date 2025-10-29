package com.iluwatar.factory.method;

/**
 * OrcWeapon.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class OrcWeapon implements Weapon {

  private final WeaponType weaponType;

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
