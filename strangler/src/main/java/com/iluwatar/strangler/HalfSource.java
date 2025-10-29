package com.iluwatar.strangler;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Source under development. Replace part of old source and has added some new features.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class HalfSource {
private static final Logger LOGGER = LoggerFactory.getLogger(HalfSource.class);
private static final  String VERSION = "1.5";

  /**
   * Implement accumulate sum with new technique.
   * Replace old one in {@link OldSource}
 *  @author Suresh Mahto
   */
public int accumulateSum(int... nums) {
LOGGER.info("Source module {}", VERSION);
return Arrays.stream(nums).reduce(0, Integer::sum);
  }

  /**
   * Check if all number is not zero.
   * New feature.
 *  @author Suresh Mahto
   */
public boolean ifNonZero(int... nums) {
LOGGER.info("Source module {}", VERSION);
return Arrays.stream(nums).allMatch(num -> num != 0);
  }
}
