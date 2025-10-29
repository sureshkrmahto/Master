package com.iluwatar.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete observer representing hobbits reacting to weather changes.
 *  @author Suresh Mahto
 */
public class Hobbits implements WeatherObserver {

private static final Logger LOGGER = LoggerFactory.getLogger(Hobbits.class);

@Override
public void update(WeatherType currentWeather) {
LOGGER.info("The hobbits are facing " + currentWeather.getDescription() + " weather now");
  }
}
