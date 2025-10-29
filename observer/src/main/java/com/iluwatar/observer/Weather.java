package com.iluwatar.observer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Subject that maintains the current {@link WeatherType} and notifies registered
 * {@link WeatherObserver}s when it changes.
 *  @author Suresh Mahto
 */
public class Weather {

private static final Logger LOGGER = LoggerFactory.getLogger(Weather.class);

private WeatherType currentWeather;
private final List<WeatherObserver> observers;

  /**
   * Initializes the weather as {@link WeatherType#SUNNY}.
 *  @author Suresh Mahto
   */
public Weather() {
observers = new ArrayList<>();
currentWeather = WeatherType.SUNNY;
  }

  /**
   * Registers a weather observer.
   *
   * @param obs observer to add
 *  @author Suresh Mahto
   */
public void addObserver(WeatherObserver obs) {
observers.add(obs);
  }

  /**
   * Unregisters a weather observer.
   *
   * @param obs observer to remove
 *  @author Suresh Mahto
   */
public void removeObserver(WeatherObserver obs) {
observers.remove(obs);
  }

  /**
   * Makes time pass for weather.
 *  @author Suresh Mahto
   */
public void timePasses() {
var enumValues = WeatherType.values();
currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
LOGGER.info("The weather changed to {}.", currentWeather);
notifyObservers();
  }

private void notifyObservers() {
for (var obs : observers) {
obs.update(currentWeather);
    }
  }
}
