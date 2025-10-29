package com.iluwatar.strangler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test methods in OldSource
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class OldSourceTest {
private static final OldSource source = new OldSource();

@Test
public void testAccumulateSum() {
assertEquals(0, source.accumulateSum(-1, 0, 1));
  }

@Test
public void testAccumulateMul() {
assertEquals(0, source.accumulateMul(-1, 0, 1));
  }
}
