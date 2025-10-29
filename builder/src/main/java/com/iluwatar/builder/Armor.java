package com.iluwatar.builder;

/**
 * Armor enumeration.
 *  @author Suresh Mahto
 */
public enum Armor {

CLOTHES("clothes"), LEATHER("leather"), CHAIN_MAIL("chain mail"), PLATE_MAIL("plate mail");

private final String title;

Armor(String title) {
this.title = title;
  }

@Override
public String toString() {
return title;
  }
}
