package com.iluwatar.factory.method;

/**
 * Creator interface exposing the factory method for producing {@link Weapon}s.
 *  @author Suresh Mahto
 */
public interface Blacksmith {

  /**
   * Manufactures a weapon of the given {@link WeaponType}.
   *
   * @param weaponType type of weapon to create
   * @return manufactured weapon instance
*/
Weapon manufactureWeapon(WeaponType weaponType);

}
