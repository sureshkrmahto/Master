package com.iluwatar.strangler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * System under migration. Depends on old version source ({@link OldSource}) and
 * developing one ({@link HalfSource}).
 */
public class HalfArithmetic {
  private static final Logger LOGGER = LoggerFactory.getLogger(HalfArithmetic.class);
  private static final String VERSION = "1.5";

  private final HalfSource newSource;
  private final OldSource oldSource;

  public HalfArithmetic(HalfSource newSource, OldSource oldSource) {
    this.newSource = newSource;
    this.oldSource = oldSource;
  }

  /**
   * Accumulate sum.
   * @param nums numbers need to add together
   * @return accumulate sum
   */
  public int sum(int... nums) {
    LOGGER.info("Arithmetic sum {}", VERSION);
    return newSource.accumulateSum(nums);
  }

  /**
   * Accumulate multiplication.
   * @param nums numbers need to multiply together
   * @return accumulate multiplication
   */
  public int mul(int... nums) {
    LOGGER.info("Arithmetic mul {}", VERSION);
    return oldSource.accumulateMul(nums);
  }

  /**
   * Chech if has any zero.
   * @param nums numbers need to check
   * @return  if has any zero, return true, else, return false
   */
  public boolean ifHasZero(int... nums) {
    LOGGER.info("Arithmetic check zero {}", VERSION);
    return !newSource.ifNonZero(nums);
  }
}
