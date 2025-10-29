package com.iluwatar.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for spell targets.
 */
public abstract class Target {

  private static final Logger LOGGER = LoggerFactory.getLogger(Target.class);

  private Size size;

  private Visibility visibility;

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public Visibility getVisibility() {
    return visibility;
  }

  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }

  @Override
  public abstract String toString();

  /**
   * Print status.
   */
  public void printStatus() {
    LOGGER.info("{}, [size={}] [visibility={}]", this, getSize(), getVisibility());
  }

  /**
   * Changes the size of the target.
   */
  public void changeSize() {
    var oldSize = getSize() == Size.NORMAL ? Size.SMALL : Size.NORMAL;
    setSize(oldSize);
  }

  /**
   * Changes the visibility of the target.
   */
  public void changeVisibility() {
    var visible = getVisibility() == Visibility.INVISIBLE
            ? Visibility.VISIBLE : Visibility.INVISIBLE;
    setVisibility(visible);
  }
}
