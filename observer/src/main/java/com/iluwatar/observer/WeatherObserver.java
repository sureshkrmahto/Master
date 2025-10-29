package com.iluwatar.observer;

/**
 * Observer interface.
 */
public interface WeatherObserver {

  /**
   * Called by {@link Weather} when its {@link WeatherType} changes.
   *
   * @param currentWeather new weather
   */
void update(WeatherType currentWeather);

}
