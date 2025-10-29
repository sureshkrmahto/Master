package com.iluwatar.privateclassdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mutable stew class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Stew {

private static final Logger LOGGER = LoggerFactory.getLogger(Stew.class);

private int numPotatoes;
private int numCarrots;
private int numMeat;
private int numPeppers;

  /**
   * Constructor.
   */
public Stew(int numPotatoes, int numCarrots, int numMeat, int numPeppers) {
this.numPotatoes = numPotatoes;
this.numCarrots = numCarrots;
this.numMeat = numMeat;
this.numPeppers = numPeppers;
  }

  /**
   * Mix the stew.
   */
public void mix() {
LOGGER.info("Mixing the stew we find: {} potatoes, {} carrots, {} meat and {} peppers",
numPotatoes, numCarrots, numMeat, numPeppers);
  }

  /**
   * Taste the stew.
   */
public void taste() {
LOGGER.info("Tasting the stew");
if (numPotatoes > 0) {
numPotatoes--;
    }
if (numCarrots > 0) {
numCarrots--;
    }
if (numMeat > 0) {
numMeat--;
    }
if (numPeppers > 0) {
numPeppers--;
    }
  }
}
