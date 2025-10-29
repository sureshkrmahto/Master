package com.iluwatar.adapter;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

/**
 * Device class (adaptee in the pattern). We want to reuse this class. Fishing boat moves by
 * sailing.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
final class FishingBoat {

  private static final Logger LOGGER = getLogger(FishingBoat.class);

  void sail() {
    LOGGER.info("The fishing boat is sailing");
  }

}
