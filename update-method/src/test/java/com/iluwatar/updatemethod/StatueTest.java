package com.iluwatar.updatemethod;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**

 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class StatueTest {

  private Statue statue;

  @Before
  public void setup() {
    statue = new Statue(1, 20);
  }

  @After
  public void tearDown() {
    statue = null;
  }

  @Test
  public void testUpdateForPendingShoot() {
    statue.frames = 10;
    statue.update();
    Assert.assertEquals(11, statue.frames);
  }

  @Test
  public void testUpdateForShooting() {
    statue.frames = 19;
    statue.update();
    Assert.assertEquals(0, statue.frames);
  }
}
