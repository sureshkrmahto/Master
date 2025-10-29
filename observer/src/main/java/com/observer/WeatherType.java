package com.observer;

/**
 * WeatherType enumeration.
 *  @author Suresh Mahto
 */
public enum WeatherType {

SUNNY("Sunny"),
RAINY("Rainy"),
WINDY("Windy"),
COLD("Cold");

private final String description;

WeatherType(String description) {
this.description = description;
  }

public String getDescription() {
return this.description;
  }

@Override
public String toString() {
return this.name().toLowerCase();
  }
}
