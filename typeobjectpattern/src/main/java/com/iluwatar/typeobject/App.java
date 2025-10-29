package com.iluwatar.typeobject;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Type object pattern is the pattern we use when the OOP concept of creating a base class and
 * inheriting from it just doesn't work for the case in hand. This happens when we either don't know
 * what types we will need upfront, or want to be able to modify or add new types conveniently w/o
 * recompiling repeatedly. The pattern provides a solution by allowing flexible creation of required
 * objects by creating one class, which has a field which represents the 'type' of the object.</p>
 * <p>In this example, we have a mini candy-crush game in action. There are many different candies
 * in the game, which may change over time, as we may want to upgrade the game. To make the object
 * creation convenient, we have a class {@link Candy} which has a field name, parent, points and
 * Type. We have a json file {@link candy} which contains the details about the candies, and this is
 * parsed to get all the different candies in {@link JsonParser}. The {@link Cell} class is what the
 * game matrix is made of, which has the candies that are to be crushed, and contains information on
 * how crushing can be done, how the matrix is to be reconfigured and how points are to be gained.
 * The {@link CellPool} class is a pool which reuses the candy cells that have been crushed instead
 * of making new ones repeatedly. The {@link CandyGame} class has the rules for the continuation of
 * the game and the {@link App} class has the game itself.</p>
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) throws IOException, ParseException {
    var givenTime = 50; //50ms
    var toWin = 500; //points
    var pointsWon = 0;
    var numOfRows = 3;
    var start = System.currentTimeMillis();
    var end = System.currentTimeMillis();
    var round = 0;
    while (pointsWon < toWin && end - start < givenTime) {
      round++;
      var pool = new CellPool(numOfRows * numOfRows + 5);
      var cg = new CandyGame(numOfRows, pool);
      if (round > 1) {
        LOGGER.info("Refreshing..");
      } else {
        LOGGER.info("Starting game..");
      }
      cg.printGameStatus();
      end = System.currentTimeMillis();
      cg.round((int) (end - start), givenTime);
      pointsWon += cg.totalPoints;
      end = System.currentTimeMillis();
    }
    LOGGER.info("Game Over");
    if (pointsWon >= toWin) {
      LOGGER.info("" + pointsWon);
      LOGGER.info("You win!!");
    } else {
      LOGGER.info("" + pointsWon);
      LOGGER.info("Sorry, you lose!");
    }
  }
}
