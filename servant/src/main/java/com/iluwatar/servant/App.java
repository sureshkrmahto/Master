package com.iluwatar.servant;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servant offers some functionality to a group of classes without defining that functionality in
 * each of them. A Servant is a class whose instance provides methods that take care of a desired
 * service, while objects for which the servant does something, are taken as parameters.
 *
 * <p>In this example {@link Servant} is serving {@link King} and {@link Queen}.
 

 * @author Suresh Mahto


 *  @author Suresh Mahto
 */
public class App {

private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

private static final Servant jenkins = new Servant("Jenkins");
private static final Servant travis = new Servant("Travis");

  /**
   * Program entry point.
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
scenario(jenkins, 1);
scenario(travis, 0);
  }

  /**
   * Can add a List with enum Actions for variable scenarios.
 *  @author Suresh Mahto
   */
public static void scenario(Servant servant, int compliment) {
var k = new King();
var q = new Queen();

var guests = List.of(k, q);

    // feed
servant.feed(k);
servant.feed(q);
    // serve drinks
servant.giveWine(k);
servant.giveWine(q);
    // compliment
servant.giveCompliments(guests.get(compliment));

    // outcome of the night
guests.forEach(Royalty::changeMood);

    // check your luck
if (servant.checkIfYouWillBeHanged(guests)) {
LOGGER.info("{} will live another day", servant.name);
    } else {
LOGGER.info("Poor {}. His days are numbered", servant.name);
    }
  }
}
