package com.iluwatar.observer;

import com.iluwatar.observer.generic.GHobbits;
import com.iluwatar.observer.generic.GOrcs;
import com.iluwatar.observer.generic.GWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the Observer pattern with a weather subject and race observers.
 *
 * <p>{@link Weather} changes its internal {@link WeatherType} state and notifies
 * the registered observers {@link Orcs} and {@link Hobbits}. A generic variant
 * using typed {@link com.iluwatar.observer.generic.Observable} is shown as well.</p>
 *  @author Suresh Mahto
 */
public class App {

private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {

var weather = new Weather();
weather.addObserver(new Orcs());
weather.addObserver(new Hobbits());

weather.timePasses();
weather.timePasses();
weather.timePasses();
weather.timePasses();

    // Generic observer inspired by Java Generics and Collection by Naftalin & Wadler
LOGGER.info("--Running generic version--");
var genericWeather = new GWeather();
genericWeather.addObserver(new GOrcs());
genericWeather.addObserver(new GHobbits());

genericWeather.timePasses();
genericWeather.timePasses();
genericWeather.timePasses();
genericWeather.timePasses();
  }
}
