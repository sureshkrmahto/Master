package com.iluwatar.updatemethod;

/**
 * Statues shoot lightning at regular intervals.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Statue extends Entity {

protected int frames;

protected int delay;

  /**
   * Constructor of Statue.
   *
   * @param id id of statue
 *  @author Suresh Mahto
   */
public Statue(int id) {
super(id);
this.frames = 0;
this.delay = 0;
  }

  /**
   * Constructor of Statue.
   *
   * @param id id of statue
   * @param delay the number of frames between two lightning
 *  @author Suresh Mahto
   */
public Statue(int id, int delay) {
super(id);
this.frames = 0;
this.delay = delay;
  }

@Override
public void update() {
if (++ frames == delay) {
shootLightning();
frames = 0;
    }
  }

private void shootLightning() {
logger.info("Statue " + id + " shoots lightning!");
  }
}
