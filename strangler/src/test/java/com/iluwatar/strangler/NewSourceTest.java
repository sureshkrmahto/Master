package com.iluwatar.strangler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test methods in NewSource
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class NewSourceTest {
private static final NewSource source = new NewSource();

@Test
public void testAccumulateSum() {
assertEquals(0, source.accumulateSum(-1, 0, 1));
  }

@Test
public void testAccumulateMul() {
assertEquals(0, source.accumulateMul(-1, 0, 1));
  }

@Test
public void testIfNonZero() {
assertFalse(source.ifNonZero(-1, 0, 1));
  }
}
