package com.gameloop;

import java.lang.reflect.InvocationTargetException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * VariableStepGameLoop unit test class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
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
