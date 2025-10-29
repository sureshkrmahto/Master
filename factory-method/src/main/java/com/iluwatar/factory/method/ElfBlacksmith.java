package com.iluwatar.factory.method;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete subclass for creating new objects.
 */
public class ElfBlacksmith implements Blacksmith {

  private static final Map<WeaponType, ElfWeapon> ELFARSENAL;

  static {
    ELFARSENAL = new HashMap<>(WeaponType.values().length);
    Arrays.stream(WeaponType.values()).forEach(type -> ELFARSENAL.put(type, new ElfWeapon(type)));
  }

  @Override
  public Weapon manufactureWeapon(WeaponType weaponType) {
    return ELFARSENAL.get(weaponType);
  }

}
