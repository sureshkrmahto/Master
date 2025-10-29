package com.builder;

/**
 * Weapon enumeration.
 *  @author Suresh Mahto
 */
public enum Weapon {

DAGGER, SWORD, AXE, WARHAMMER, BOW;

@Override
public String toString() {
return name().toLowerCase();
  }
}
