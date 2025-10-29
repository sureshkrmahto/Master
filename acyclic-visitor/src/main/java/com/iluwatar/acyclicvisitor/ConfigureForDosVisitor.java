package com.iluwatar.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ConfigureForDosVisitor class implements both zoom's and  hayes' visit method for Dos
 * manufacturer.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ConfigureForDosVisitor implements AllModemVisitor {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForDosVisitor.class);

  @Override
  public void visit(Hayes hayes) {
    LOGGER.info(hayes + " used with Dos configurator.");
  }

  @Override
  public void visit(Zoom zoom) {
    LOGGER.info(zoom + " used with Dos configurator.");
  }
}
