package com.iluwatar.twin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents a Ball which extends {@link GameItem} and implements the logic for ball
 * item, like move and draw. It hold a reference of {@link BallThread} to delegate the suspend and
 * resume task.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class BallItem extends GameItem {

  private static final Logger LOGGER = LoggerFactory.getLogger(BallItem.class);

  private boolean isSuspended;

  private BallThread twin;

  public void setTwin(BallThread twin) {
    this.twin = twin;
  }

  @Override
  public void doDraw() {

    LOGGER.info("doDraw");
  }

  public void move() {
    LOGGER.info("move");
  }

  @Override
  public void click() {

    isSuspended = !isSuspended;

    if (isSuspended) {
      twin.suspendMe();
    } else {
      twin.resumeMe();
    }
  }
}

