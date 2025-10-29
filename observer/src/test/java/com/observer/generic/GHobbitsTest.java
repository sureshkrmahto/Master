package com.observer.generic;

import com.observer.WeatherType;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class GHobbitsTest extends ObserverTest<GHobbits> {

@Override
public Collection<Object[]> dataProvider() {
return List.of(
new Object[]{WeatherType.SUNNY, "The hobbits are facing Sunny weather now"},
new Object[]{WeatherType.RAINY, "The hobbits are facing Rainy weather now"},
new Object[]{WeatherType.WINDY, "The hobbits are facing Windy weather now"},
new Object[]{WeatherType.COLD, "The hobbits are facing Cold weather now"}
    );
  }

  /**
   * Create a new test with the given weather and expected response
 *  @author Suresh Mahto
   */
public GHobbitsTest() {
super(GHobbits::new);
  }

}
