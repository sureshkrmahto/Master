package com.iluwatar.gameloop;

import java.lang.reflect.InvocationTargetException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * VariableStepGameLoop unit test class.
 */
public class VariableStepGameLoopTest {

  private VariableStepGameLoop gameLoop;

  @Before
  public void setup() {
    gameLoop = new VariableStepGameLoop();
  }

  @After
  public void tearDown() {
    gameLoop = null;
  }

  @Test
  public void testUpdate() {
    gameLoop.update(20L);
    Assert.assertEquals(0.01f, gameLoop.controller.getBulletPosition(), 0);
  }
}
