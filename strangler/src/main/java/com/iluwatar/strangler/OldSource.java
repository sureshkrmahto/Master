package com.iluwatar.strangler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Old source with techniques out of date.
 */
public class OldSource {
  private static final Logger LOGGER = LoggerFactory.getLogger(OldSource.class);
  private static final String VERSION = "1.0";

  /**
   * Implement accumulate sum with old technique.
   */
  public int accumulateSum(int... nums) {
    LOGGER.info("Source module {}", VERSION);
    var sum = 0;
    for (final var num : nums) {
      sum += num;
    }
    return sum;
  }

  /**
   * Implement accumulate multiply with old technique.
   */
  public int accumulateMul(int... nums) {
    LOGGER.info("Source module {}", VERSION);
    var sum = 1;
    for (final var num : nums) {
      sum *= num;
    }
    return sum;
  }
}
