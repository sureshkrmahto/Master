package com.iluwatar.model.view.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GiantView displays the giant.
 */
public class GiantView {

  private static final Logger LOGGER = LoggerFactory.getLogger(GiantView.class);

  public void displayGiant(GiantModel giant) {
    LOGGER.info(giant.toString());
  }
}
