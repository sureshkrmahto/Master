package com.strangler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test methods in OldArithmetic
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class OldArithmeticTest {
private static final OldArithmetic arithmetic = new OldArithmetic(new OldSource());

@Test
public void testSum() {
assertEquals(0, arithmetic.sum(-1, 0, 1));
  }

@Test
public void testMul() {
assertEquals(0, arithmetic.mul(-1, 0, 1));
  }
}