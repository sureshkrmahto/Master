package com.iluwatar.observer.generic;

import com.iluwatar.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic observer representing orcs reacting to weather updates.
 *  @author Suresh Mahto
 */
public class GOrcs implements Race {

private static final Logger LOGGER = LoggerFactory.getLogger(GOrcs.class);

@Override
public void update(GWeather weather, WeatherType weatherType) {
LOGGER.info("The orcs are facing " + weatherType.getDescription() + " weather now");
  }
}
