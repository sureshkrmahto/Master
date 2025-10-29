package com.event.aggregator;

/**
 * Event enumeration.
 *  @author Suresh Mahto
 */
public enum Event {

STARK_SIGHTED("Stark sighted"), WARSHIPS_APPROACHING("Warships approaching"), TRAITOR_DETECTED(
      "Traitor detected");

private final String description;

Event(String description) {
this.description = description;
  }

public String toString() {
return description;
  }
}
