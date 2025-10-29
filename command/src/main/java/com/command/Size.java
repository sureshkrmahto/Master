package com.command;

/**
 * Enumeration for target size.
 *  @author Suresh Mahto
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
