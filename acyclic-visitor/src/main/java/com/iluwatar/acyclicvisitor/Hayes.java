package com.iluwatar.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hayes class implements its accept method.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Hayes extends Modem {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForDosVisitor.class);

  /**
   * Accepts all visitors but honors only HayesVisitor.
   */
  @Override
  public void accept(ModemVisitor modemVisitor) {
    if (modemVisitor instanceof HayesVisitor) {
      ((HayesVisitor) modemVisitor).visit(this);
    } else {
      LOGGER.info("Only HayesVisitor is allowed to visit Hayes modem");
    }

  }

  /**
   * Hayes' modem's toString method.
   */
  @Override
  public String toString() {
    return "Hayes modem";
  }
}
