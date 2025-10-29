package com.iluwatar.updatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for all the entity types.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public abstract class Entity {

  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  protected int id;

  protected int position;

  public Entity(int id) {
    this.id = id;
    this.position = 0;
  }

  public abstract void update();

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }
}
