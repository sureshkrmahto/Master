package com.iluwatar.privateclassdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Immutable stew class, protected with Private Class Data pattern.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ImmutableStew {

  private static final Logger LOGGER = LoggerFactory.getLogger(ImmutableStew.class);

  private final StewData data;

  public ImmutableStew(int numPotatoes, int numCarrots, int numMeat, int numPeppers) {
    data = new StewData(numPotatoes, numCarrots, numMeat, numPeppers);
  }

  /**
   * Mix the stew.
   */
  public void mix() {
    LOGGER
        .info("Mixing the immutable stew we find: {} potatoes, {} carrots, {} meat and {} peppers",
            data.getNumPotatoes(), data.getNumCarrots(), data.getNumMeat(), data.getNumPeppers());
  }
}
