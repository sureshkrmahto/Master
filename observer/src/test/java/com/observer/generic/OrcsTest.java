package com.observer.generic;

import com.observer.WeatherType;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class OrcsTest extends ObserverTest<GOrcs> {

@Override
public Collection<Object[]> dataProvider() {
return List.of(
new Object[]{WeatherType.SUNNY, "The orcs are facing Sunny weather now"},
new Object[]{WeatherType.RAINY, "The orcs are facing Rainy weather now"},
new Object[]{WeatherType.WINDY, "The orcs are facing Windy weather now"},
new Object[]{WeatherType.COLD, "The orcs are facing Cold weather now"}
    );
  }

  /**
   * Create a new test with the given weather and expected response
 *  @author Suresh Mahto
   */
public OrcsTest() {
super(GOrcs::new);
  }

}
