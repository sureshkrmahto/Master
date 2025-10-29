package com.iluwatar.updatemethod;

/**
 * Skeletons are always patrolling on the game map. Initially all the skeletons
 * patrolling to the right, and after them reach the bounding, it will start
 * patrolling to the left. For each frame, one skeleton will move 1 position
 * step.
 */
public class Skeleton extends Entity {

  private static final int PATROLLING_LEFT_BOUNDING = 0;

  private static final int PATROLLING_RIGHT_BOUNDING = 100;

  protected boolean patrollingLeft;

  /**
   * Constructor of Skeleton.
   *
   * @param id id of skeleton
   */
  public Skeleton(int id) {
    super(id);
    patrollingLeft = false;
  }

  /**
   * Constructor of Skeleton.
   *
   * @param id id of skeleton
   * @param postition position of skeleton
   */
  public Skeleton(int id, int postition) {
    super(id);
    this.position = position;
    patrollingLeft = false;
  }

  @Override
  public void update() {
    if (patrollingLeft) {
      position -= 1;
      if (position == PATROLLING_LEFT_BOUNDING) {
        patrollingLeft = false;
      }
    } else {
      position += 1;
      if (position == PATROLLING_RIGHT_BOUNDING) {
        patrollingLeft = true;
      }
    }
    logger.info("Skeleton " + id + " is on position " + position + ".");
  }
}

