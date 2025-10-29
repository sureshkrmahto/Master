package com.subclasssandbox;

import org.slf4j.Logger;

/**
 * Superpower abstract class. In this class the basic operations of all types of
 * superpowers are provided as protected methods.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Superpower {

protected Logger logger;

  /**
   * Subclass of superpower should implement this sandbox method by calling the
   * methods provided in this super class.
 *  @author Suresh Mahto
   */
protected abstract void activate();

  /**
   * Move to (x, y, z).
   * @param x X coordinate.
   * @param y Y coordinate.
   * @param z Z coordinate.
 *  @author Suresh Mahto
   */
protected void move(double x, double y, double z) {
logger.info("Move to ( " + x + ", " + y + ", " + z + " )");
  }

  /**
   * Play sound effect for the superpower.
   * @param soundName Sound name.
   * @param volumn Value of volumn.
 *  @author Suresh Mahto
   */
protected void playSound(String soundName, int volumn) {
logger.info("Play " + soundName + " with volumn " + volumn);
  }

  /**
   * Spawn particles for the superpower.
   * @param particleType Particle type.
   * @param count Count of particles to be spawned.
 *  @author Suresh Mahto
   */
protected void spawnParticles(String particleType, int count) {
logger.info("Spawn " + count + " particle with type " + particleType);
  }
}
