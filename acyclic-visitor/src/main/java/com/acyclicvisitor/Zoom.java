package com.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Zoom class implements its accept method.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Zoom extends Modem {

private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForDosVisitor.class);

  /**
   * Accepts all visitors but honors only ZoomVisitor.
 *  @author Suresh Mahto
   */
  @Override
public void accept(ModemVisitor modemVisitor) {
if (modemVisitor instanceof ZoomVisitor) {
      ((ZoomVisitor) modemVisitor).visit(this);
    } else {
LOGGER.info("Only ZoomVisitor is allowed to visit Zoom modem");
    }
  }

  /**
   * Zoom modem's toString method.
 *  @author Suresh Mahto
   */
  @Override
public String toString() {
return "Zoom modem";
  }
}
