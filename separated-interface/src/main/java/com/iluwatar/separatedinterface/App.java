package com.iluwatar.separatedinterface;

import com.iluwatar.separatedinterface.invoice.InvoiceGenerator;
import com.iluwatar.separatedinterface.taxes.DomesticTaxCalculator;
import com.iluwatar.separatedinterface.taxes.ForeignTaxCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>The Separated Interface pattern encourages to separate the interface definition and
 * implementation in different packages. This allows the client to be completely unaware of the
 * implementation.</p>
 *
 * <p>In this class the {@link InvoiceGenerator} class is injected with different instances of
 * {@link com.iluwatar.separatedinterface.invoice.TaxCalculator} implementations located in separate
 * packages, to receive different responses for both of the implementations.</p>
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  public static final double PRODUCT_COST = 50.0;

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    //Create the invoice generator with product cost as 50 and foreign product tax
    var internationalProductInvoice = new InvoiceGenerator(PRODUCT_COST,
        new ForeignTaxCalculator());
    LOGGER.info("Foreign Tax applied: {}", "" + internationalProductInvoice.getAmountWithTax());

    //Create the invoice generator with product cost as 50 and domestic product tax
    var domesticProductInvoice = new InvoiceGenerator(PRODUCT_COST, new DomesticTaxCalculator());
    LOGGER.info("Domestic Tax applied: {}", "" + domesticProductInvoice.getAmountWithTax());
  }
}
