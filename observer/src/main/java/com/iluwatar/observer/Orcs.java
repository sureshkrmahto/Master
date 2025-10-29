package com.iluwatar.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete observer representing orcs reacting to weather changes.
 *  @author Suresh Mahto
 */
public class Orcs implements WeatherObserver {

private static final Logger LOGGER = LoggerFactory.getLogger(Orcs.class);

@Override
public void update(WeatherType currentWeather) {
LOGGER.info("The orcs are facing " + currentWeather.getDescription() + " weather now");
  }
}
