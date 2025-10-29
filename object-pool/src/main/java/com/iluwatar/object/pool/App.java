package com.iluwatar.object.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When it is necessary to work with a large number of objects that are particularly expensive to
 * instantiate and each object is only needed for a short period of time, the performance of an
 * entire application may be adversely affected. An object pool design pattern may be deemed
 * desirable in cases such as these.
 *
 * <p>The object pool design pattern creates a set of objects that may be reused. When a new object
 * is needed, it is requested from the pool. If a previously prepared object is available it is
 * returned immediately, avoiding the instantiation cost. If no objects are present in the pool, a
 * new item is created and returned. When the object has been used and is no longer needed, it is
 * returned to the pool, allowing it to be used again in the future without repeating the
 * computationally expensive instantiation process. It is important to note that once an object has
 * been used and returned, existing references will become invalid.
 *
 * <p>In this example we have created {@link OliphauntPool} inheriting from generic {@link
 * ObjectPool}. {@link Oliphaunt}s can be checked out from the pool and later returned to it. The
 * pool tracks created instances and their status (available, inUse).
 
 * @author Suresh Mahto

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
var pool = new OliphauntPool();
LOGGER.info(pool.toString());
var oliphaunt1 = pool.checkOut();
String checkedOut = "Checked out {}";

LOGGER.info(checkedOut, oliphaunt1);
LOGGER.info(pool.toString());
var oliphaunt2 = pool.checkOut();
LOGGER.info(checkedOut, oliphaunt2);
var oliphaunt3 = pool.checkOut();
LOGGER.info(checkedOut, oliphaunt3);
LOGGER.info(pool.toString());
LOGGER.info("Checking in {}", oliphaunt1);
pool.checkIn(oliphaunt1);
LOGGER.info("Checking in {}", oliphaunt2);
pool.checkIn(oliphaunt2);
LOGGER.info(pool.toString());
var oliphaunt4 = pool.checkOut();
LOGGER.info(checkedOut, oliphaunt4);
var oliphaunt5 = pool.checkOut();
LOGGER.info(checkedOut, oliphaunt5);
LOGGER.info(pool.toString());
  }
}
