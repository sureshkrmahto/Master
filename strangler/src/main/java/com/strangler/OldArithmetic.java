package com.strangler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Old version system depends on old version source ({@link OldSource}).
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class OldArithmetic {
private static final Logger LOGGER = LoggerFactory.getLogger(OldArithmetic.class);
private static final  String VERSION = "1.0";

private final OldSource source;

public OldArithmetic(OldSource source) {
this.source = source;
  }

  /**
   * Accumulate sum.
   * @param nums numbers need to add together
   * @return accumulate sum
 *  @author Suresh Mahto
   */
public int sum(int... nums) {
LOGGER.info("Arithmetic sum {}", VERSION);
return source.accumulateSum(nums);
  }

  /**
   * Accumulate multiplication.
   * @param nums numbers need to multiply together
   * @return accumulate multiplication
 *  @author Suresh Mahto
   */
public int mul(int... nums) {
LOGGER.info("Arithmetic mul {}", VERSION);
return source.accumulateMul(nums);
  }
}
