package com.iluwatar.strangler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test methods in HalfSource
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class HalfSourceTest {
private static final HalfSource source = new HalfSource();

@Test
public void testAccumulateSum() {
assertEquals(0, source.accumulateSum(-1, 0, 1));
  }

@Test
public void testIfNonZero() {
assertFalse(source.ifNonZero(-1, 0, 1));
  }
}
