package com.iluwatar.separatedinterface.taxes;

import com.iluwatar.separatedinterface.invoice.TaxCalculator;

/**
 * TaxCalculator for foreign goods with 60% tax.
 */
public class ForeignTaxCalculator implements TaxCalculator {

  public static final double TAX_PERCENTAGE = 60;

  @Override
  public double calculate(double amount) {
    return amount * TAX_PERCENTAGE / 100.0;
  }

}
