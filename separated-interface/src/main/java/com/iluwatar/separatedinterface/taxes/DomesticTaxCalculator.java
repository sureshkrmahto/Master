package com.iluwatar.separatedinterface.taxes;

import com.iluwatar.separatedinterface.invoice.TaxCalculator;

/**
 * TaxCalculator for Domestic goods with 20% tax.
 */
public class DomesticTaxCalculator implements TaxCalculator {

  public static final double TAX_PERCENTAGE = 20;

  @Override
  public double calculate(double amount) {
    return amount * TAX_PERCENTAGE / 100.0;
  }

}
