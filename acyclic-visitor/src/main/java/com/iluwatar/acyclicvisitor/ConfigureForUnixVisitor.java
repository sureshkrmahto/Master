package com.iluwatar.acyclicvisitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ConfigureForUnixVisitor class implements zoom's visit method for Unix manufacturer, unlike
 * traditional visitor pattern, this class may selectively implement visit for other modems.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class ConfigureForUnixVisitor implements ZoomVisitor {

private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForUnixVisitor.class);

@Override
public void visit(Zoom zoom) {
LOGGER.info(zoom + " used with Unix configurator.");
  }
}