package com.iluwatar.strangler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * System after whole migration. Only depends on new version source ({@link NewSource}).
 */
public class NewArithmetic {
  private static final Logger LOGGER = LoggerFactory.getLogger(NewArithmetic.class);
  private static final  String VERSION = "2.0";

  private final NewSource source;

  public NewArithmetic(NewSource source) {
    this.source = source;
  }

  /**
   * Accumulate sum.
   * @param nums numbers need to add together
   * @return accumulate sum
   */
  public int sum(int... nums) {
    LOGGER.info("Arithmetic sum {}", VERSION);
    return source.accumulateSum(nums);
  }

  /**
   * Accumulate multiplication.
   * @param nums numbers need to multiply together
   * @return accumulate multiplication
   */
  public int mul(int... nums) {
    LOGGER.info("Arithmetic mul {}", VERSION);
    return source.accumulateMul(nums);
  }

  /**
   * Chech if has any zero.
   * @param nums numbers need to check
   * @return  if has any zero, return true, else, return false
   */
  public boolean ifHasZero(int... nums) {
    LOGGER.info("Arithmetic check zero {}", VERSION);
    return !source.ifNonZero(nums);
  }
}
