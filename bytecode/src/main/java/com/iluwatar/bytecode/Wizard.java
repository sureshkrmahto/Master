package com.iluwatar.bytecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represent game objects which properties can be changed by instructions interpreted by
 * virtual machine.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Wizard {
private static final Logger LOGGER = LoggerFactory.getLogger(Wizard.class);

private int health;

private int agility;
private int wisdom;

private int numberOfPlayedSounds;
private int numberOfSpawnedParticles;

public int getHealth() {
return health;
  }

public void setHealth(int health) {
this.health = health;
  }

public int getAgility() {
return agility;
  }

public void setAgility(int agility) {
this.agility = agility;
  }

public int getWisdom() {
return wisdom;
  }

public void setWisdom(int wisdom) {
this.wisdom = wisdom;
  }

public void playSound() {
LOGGER.info("Playing sound");
numberOfPlayedSounds++;
  }

public void spawnParticles() {
LOGGER.info("Spawning particles");
numberOfSpawnedParticles++;
  }

public int getNumberOfPlayedSounds() {
return numberOfPlayedSounds;
  }

public int getNumberOfSpawnedParticles() {
return numberOfSpawnedParticles;
  }
}
