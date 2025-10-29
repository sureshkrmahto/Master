package com.iluwatar.strangler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test methods in HalfArithmetic
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class HalfArithmeticTest {
private static final HalfArithmetic arithmetic = new HalfArithmetic(new HalfSource(), new OldSource());

@Test
public void testSum() {
assertEquals(0, arithmetic.sum(-1, 0, 1));
  }

@Test
public void testMul() {
assertEquals(0, arithmetic.mul(-1, 0, 1));
  }

@Test
public void testIfHasZero() {
assertTrue(arithmetic.ifHasZero(-1, 0, 1));
  }
}