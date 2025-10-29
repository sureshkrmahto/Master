package com.gameloop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * FrameBasedGameLoop unit test class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class FrameBasedGameLoopTest {

private FrameBasedGameLoop gameLoop;

@Before
public void setup() {
gameLoop = new FrameBasedGameLoop();
  }

@After
public void tearDown() {
gameLoop = null;
  }

@Test
public void testUpdate() {
gameLoop.update();
Assert.assertEquals(0.5f, gameLoop.controller.getBulletPosition(), 0);
  }
}
