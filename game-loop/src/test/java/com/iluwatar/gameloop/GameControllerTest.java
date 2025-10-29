package com.iluwatar.gameloop;

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
public class GameControllerTest {

  private GameController controller;

  @Before
  public void setup() {
    controller = new GameController();
  }

  @After
  public void tearDown() {
    controller = null;
  }

  @Test
  public void testMoveBullet() {
    controller.moveBullet(1.5f);
    Assert.assertEquals(1.5f, controller.bullet.getPosition(), 0);
  }

  @Test
  public void testGetBulletPosition() {
    Assert.assertEquals(controller.bullet.getPosition(), controller.getBulletPosition(), 0);
  }

}
