package com.updatemethod;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class WorldTest {

private World world;

@Before
public void setup() {
world = new World();
  }

@After
public void tearDown() {
world = null;
  }

@Test
public void testRun() {
world.run();
Assert.assertEquals(true, world.isRunning);
  }

@Test
public void testStop() {
world.stop();
Assert.assertEquals(false, world.isRunning);
  }

@Test
public void testAddEntity() {
var entity = new Skeleton(1);
world.addEntity(entity);
Assert.assertEquals(entity, world.entities.get(0));
  }
}
