package com.iluwatar.separatedinterface.taxes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ForeignTaxCalculatorTest {

private ForeignTaxCalculator target;

@Test
public void testTaxCalculation(){
target = new ForeignTaxCalculator();

var tax=target.calculate(100.0);
Assertions.assertEquals(tax,60.0);
  }

}
