package com.builder;

/**
 * HairColor enumeration.
 *  @author Suresh Mahto
 */
public enum HairColor {

WHITE, BLOND, RED, BROWN, BLACK;

@Override
public String toString() {
return name().toLowerCase();
  }

}
