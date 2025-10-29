package com.iluwatar.command;

/**
 * Enumeration for target size.
 */
public enum Size {

  SMALL("small"), NORMAL("normal");

  private final String title;

  Size(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}
