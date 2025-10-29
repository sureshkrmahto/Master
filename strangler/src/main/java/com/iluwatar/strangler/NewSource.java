package com.iluwatar.strangler;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * New source. Completely covers functionalities of old source with new techniques
 * and also has some new features.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class NewSource {
  private static final Logger LOGGER = LoggerFactory.getLogger(NewSource.class);
  private static final  String VERSION = "2.0";
  public static final String SOURCE_MODULE = "Source module {}";

  public int accumulateSum(int... nums) {
    LOGGER.info(SOURCE_MODULE, VERSION);
    return Arrays.stream(nums).reduce(0, Integer::sum);
  }

  /**
   * Implement accumulate multiply with new technique.
   * Replace old one in {@link OldSource}
   */
  public int accumulateMul(int... nums) {
    LOGGER.info(SOURCE_MODULE, VERSION);
    return Arrays.stream(nums).reduce(1, (a, b) -> a * b);
  }

  public boolean ifNonZero(int... nums) {
    LOGGER.info(SOURCE_MODULE, VERSION);
    return Arrays.stream(nums).allMatch(num -> num != 0);
  }
}
