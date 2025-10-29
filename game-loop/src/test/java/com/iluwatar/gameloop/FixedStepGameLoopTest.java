package com.iluwatar.gameloop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * FixedStepGameLoop unit test class.
 */
public class FixedStepGameLoopTest {

  private FixedStepGameLoop gameLoop;

  @Before
  public void setup() {
    gameLoop = new FixedStepGameLoop();
  }

  @After
  public void tearDown() {
    gameLoop = null;
  }

  @Test
  public void testUpdate() {
    gameLoop.update();
    Assert.assertEquals(0.01f, gameLoop.controller.getBulletPosition(), 0);
  }

}
