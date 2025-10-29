package com.model.view.controller;

/**
 * Nourishment enumeration.
 *  @author Suresh Mahto
 */
public enum Nourishment {
SATURATED("saturated"),
HUNGRY("hungry"),
STARVING("starving");

private final String title;

Nourishment(String title) {
this.title = title;
  }

@Override
public String toString() {
return title;
  }
}
