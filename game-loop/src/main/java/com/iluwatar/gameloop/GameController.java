package com.iluwatar.gameloop;

/**
 * Update and render objects in the game. Here we add a Bullet object to the
 * game system to show how the game loop works.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GameController {

protected final Bullet bullet;

  /**
   * Initialize Bullet instance.
 *  @author Suresh Mahto
   */
public GameController() {
bullet = new Bullet();
  }

  /**
   * Move bullet position by the provided offset.
   *
   * @param offset moving offset
 *  @author Suresh Mahto
   */
public void moveBullet(float offset) {
var currentPosition = bullet.getPosition();
bullet.setPosition(currentPosition + offset);
  }

  /**
   * Get current position of the bullet.
   *
   * @return position of bullet
 *  @author Suresh Mahto
   */
public float getBulletPosition() {
return bullet.getPosition();
  }

}

