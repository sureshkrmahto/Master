package com.iluwatar.model.view.controller;

/**
 * Health enumeration.
 *  @author Suresh Mahto
 */
public enum Health {
HEALTHY("healthy"),
WOUNDED("wounded"),
DEAD("dead");

private final String title;

Health(String title) {
this.title = title;
  }

@Override
public String toString() {
return title;
  }
}
