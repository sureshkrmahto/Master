package com.builder;

/**
 * Profession enumeration.
 *  @author Suresh Mahto
 */
public enum Profession {

WARRIOR, THIEF, MAGE, PRIEST;

@Override
public String toString() {
return name().toLowerCase();
  }
}
