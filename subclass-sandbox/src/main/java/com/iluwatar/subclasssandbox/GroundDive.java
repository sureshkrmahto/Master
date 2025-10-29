package com.iluwatar.subclasssandbox;

import org.slf4j.LoggerFactory;

/**
 * GroundDive superpower.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GroundDive extends Superpower {

public GroundDive() {
super();
logger = LoggerFactory.getLogger(GroundDive.class);
  }

@Override
protected void activate() {
move(0, 0, -20);
playSound("GROUNDDIVE_SOUND", 5);
spawnParticles("GROUNDDIVE_PARTICLE", 20);
  }
}
