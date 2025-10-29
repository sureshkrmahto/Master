package com.observer.generic;

import com.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic subject that cycles through {@link com.observer.WeatherType}
 * values and notifies registered {@link Race} observers.
 *  @author Suresh Mahto
 */
public class GWeather extends Observable<GWeather, Race, WeatherType> {

private static final Logger LOGGER = LoggerFactory.getLogger(GWeather.class);

private WeatherType currentWeather;

public GWeather() {
currentWeather = WeatherType.SUNNY;
  }

  /**
   * Makes time pass for weather.
 *  @author Suresh Mahto
   */
public void timePasses() {
var enumValues = WeatherType.values();
currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
LOGGER.info("The weather changed to {}.", currentWeather);
notifyObservers(currentWeather);
  }
}
