package com.observer.generic;

import com.observer.WeatherObserver;
import com.observer.WeatherType;
import com.observer.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class GWeatherTest {

private InMemoryAppender appender;

@BeforeEach
public void setUp() {
appender = new InMemoryAppender(GWeather.class);
  }

@AfterEach
public void tearDown() {
appender.stop();
  }

  /**
   * Add a {@link WeatherObserver}, verify if it gets notified of a weather change, remove the
   * observer again and verify that there are no more notifications.
 *  @author Suresh Mahto
   */
  @Test
public void testAddRemoveObserver() {
final var observer = mock(Race.class);

final var weather = new GWeather();
weather.addObserver(observer);
verifyZeroInteractions(observer);

weather.timePasses();
assertEquals("The weather changed to rainy.", appender.getLastMessage());
verify(observer).update(weather, WeatherType.RAINY);

weather.removeObserver(observer);
weather.timePasses();
assertEquals("The weather changed to windy.", appender.getLastMessage());

verifyNoMoreInteractions(observer);
assertEquals(2, appender.getLogSize());
  }

  /**
   * Verify if the weather passes in the order of the {@link WeatherType}s
 *  @author Suresh Mahto
   */
  @Test
public void testTimePasses() {
final var observer = mock(Race.class);
final var weather = new GWeather();
weather.addObserver(observer);

final var inOrder = inOrder(observer);
final var weatherTypes = WeatherType.values();
for (var i = 1; i < 20; i++) {
weather.timePasses();
inOrder.verify(observer).update(weather, weatherTypes[i % weatherTypes.length]);
    }

verifyNoMoreInteractions(observer);
  }

}
