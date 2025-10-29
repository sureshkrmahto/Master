package com.iluwatar.observer.generic;

import com.iluwatar.observer.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic subject that cycles through {@link com.iluwatar.observer.WeatherType}
 * values and notifies registered {@link Race} observers.
 */
public class GWeather extends Observable<GWeather, Race, WeatherType> {

  private static final Logger LOGGER = LoggerFactory.getLogger(GWeather.class);

  private WeatherType currentWeather;

  public GWeather() {
    currentWeather = WeatherType.SUNNY;
  }

  /**
   * Makes time pass for weather.
   */
  public void timePasses() {
    var enumValues = WeatherType.values();
    currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
    LOGGER.info("The weather changed to {}.", currentWeather);
    notifyObservers(currentWeather);
  }
}
