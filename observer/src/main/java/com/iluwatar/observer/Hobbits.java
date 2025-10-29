package com.iluwatar.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hobbits.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Hobbits implements WeatherObserver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Hobbits.class);

  @Override
  public void update(WeatherType currentWeather) {
    LOGGER.info("The hobbits are facing " + currentWeather.getDescription() + " weather now");
  }
}
