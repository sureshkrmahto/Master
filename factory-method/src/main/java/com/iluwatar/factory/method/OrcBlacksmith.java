package com.iluwatar.factory.method;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete subclass for creating new objects.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class OrcBlacksmith implements Blacksmith {

  private static final Map<WeaponType, OrcWeapon> ORCARSENAL;

  static {
    ORCARSENAL = new HashMap<>(WeaponType.values().length);
    Arrays.stream(WeaponType.values()).forEach(type -> ORCARSENAL.put(type, new OrcWeapon(type)));
  }
  
  @Override
  public Weapon manufactureWeapon(WeaponType weaponType) {
    return ORCARSENAL.get(weaponType);
  }
}
