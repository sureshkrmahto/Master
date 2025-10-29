package com.iluwatar.factory.method;

/**
 * WeaponType enumeration.
 *  @author Suresh Mahto
 */
public enum WeaponType {

SHORT_SWORD("short sword"), SPEAR("spear"), AXE("axe"), UNDEFINED("");

private final String title;

WeaponType(String title) {
this.title = title;
  }

@Override
public String toString() {
return title;
  }
}
