package com.iluwatar.observer.generic;

import com.iluwatar.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GHobbits.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class GHobbits implements Race {

  private static final Logger LOGGER = LoggerFactory.getLogger(GHobbits.class);

  @Override
  public void update(GWeather weather, WeatherType weatherType) {
    LOGGER.info("The hobbits are facing " + weatherType.getDescription() + " weather now");
  }
}
