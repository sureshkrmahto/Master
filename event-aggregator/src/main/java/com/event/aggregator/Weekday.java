package com.event.aggregator;

/**
 * Weekday enumeration.
 *  @author Suresh Mahto
 */
public enum Weekday {

MONDAY("Monday"),
TUESDAY("Tuesday"),
WEDNESDAY("Wednesday"),
THURSDAY("Thursday"),
FRIDAY("Friday"),
SATURDAY("Saturday"),
SUNDAY("Sunday");

private final String description;

Weekday(String description) {
this.description = description;
  }

public String toString() {
return description;
  }
}
