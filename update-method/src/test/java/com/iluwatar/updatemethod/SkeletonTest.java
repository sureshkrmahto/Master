package com.iluwatar.updatemethod;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SkeletonTest {

private Skeleton skeleton;

@Before
public void setup() {
skeleton = new Skeleton(1);
  }

@After
public void tearDown() {
skeleton = null;
  }

@Test
public void testUpdateForPatrollingLeft() {
skeleton.patrollingLeft = true;
skeleton.setPosition(50);
skeleton.update();
Assert.assertEquals(49, skeleton.getPosition());
  }

@Test
public void testUpdateForPatrollingRight() {
skeleton.patrollingLeft = false;
skeleton.setPosition(50);
skeleton.update();
Assert.assertEquals(51, skeleton.getPosition());
  }

@Test
public void testUpdateForReverseDirectionFromLeftToRight() {
skeleton.patrollingLeft = true;
skeleton.setPosition(1);
skeleton.update();
Assert.assertEquals(0, skeleton.getPosition());
Assert.assertEquals(false, skeleton.patrollingLeft);
  }

@Test
public void testUpdateForReverseDirectionFromRightToLeft() {
skeleton.patrollingLeft = false;
skeleton.setPosition(99);
skeleton.update();
Assert.assertEquals(100, skeleton.getPosition());
Assert.assertEquals(true, skeleton.patrollingLeft);
  }
}
