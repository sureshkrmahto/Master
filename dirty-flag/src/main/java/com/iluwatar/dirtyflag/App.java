package com.iluwatar.dirtyflag;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This application demonstrates the <b>Dirty Flag</b> pattern. The dirty flag behavioral pattern
 * allows you to avoid expensive operations that would just need to be done again anyway. This is a
 * simple pattern that really just explains how to add a bool value to your class that you can set
 * anytime a property changes. This will let your class know that any results it may have previously
 * calculated will need to be calculated again when they’re requested. Once the results are
 * re-calculated, then the bool value can be cleared.
 *
 * <p>There are some points that need to be considered before diving into using this pattern:-
 * there are some things you’ll need to consider:- (1) Do you need it? This design pattern works
 * well when the results to be calculated are difficult or resource intensive to compute. You want
 * to save them. You also don’t want to be calculating them several times in a row when only the
 * last one counts. (2) When do you set the dirty flag? Make sure that you set the dirty flag within
 * the class itself whenever an important property changes. This property should affect the result
 * of the calculated result and by changing the property, that makes the last result invalid. (3)
 * When do you clear the dirty flag? It might seem obvious that the dirty flag should be cleared
 * whenever the result is calculated with up-to-date information but there are other times when you
 * might want to clear the flag.
 *
 * <p>In this example, the {@link DataFetcher} holds the <i>dirty flag</i>. It fetches and
 * re-fetches from <i>world.txt</i> when needed. {@link World} mainly serves the data to the
 * front-end.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program execution point.
 *  @author Suresh Mahto
   */
public void run() {
final var executorService = Executors.newSingleThreadScheduledExecutor();
executorService.scheduleAtFixedRate(new Runnable() {
final World world = new World();

@Override
public void run() {
var countries = world.fetch();
LOGGER.info("Our world currently has the following countries:-");
countries.stream().map(country -> "\t" + country).forEach(LOGGER::info);
      }
    }, 0, 15, TimeUnit.SECONDS); // Run at every 15 seconds.
  }

  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var app = new App();
app.run();
  }

}
