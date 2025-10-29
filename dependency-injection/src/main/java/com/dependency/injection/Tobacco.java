package com.dependency.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tobacco abstraction.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Tobacco {

private static final Logger LOGGER = LoggerFactory.getLogger(Tobacco.class);

public void smoke(Wizard wizard) {
LOGGER.info("{} smoking {}", wizard.getClass().getSimpleName(),
this.getClass().getSimpleName());
  }
}
