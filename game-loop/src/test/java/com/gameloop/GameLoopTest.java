package com.gameloop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * GameLoop unit test class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GameLoopTest {

private GameLoop gameLoop;

  /**
   * Create mock implementation of GameLoop.
 *  @author Suresh Mahto
   */
  @Before
public void setup() {
gameLoop = new GameLoop() {
@Override
protected void processGameLoop() {}
    };
  }

@After
public void tearDown() {
gameLoop = null;
  }

@Test
public void testRun() {
gameLoop.run();
Assert.assertEquals(GameStatus.RUNNING, gameLoop.status);
  }

@Test
public void testStop() {
gameLoop.stop();
Assert.assertEquals(GameStatus.STOPPED, gameLoop.status);
  }

@Test
public void testIsGameRunning() {
Assert.assertFalse(gameLoop.isGameRunning());
  }

}
