package com.iluwatar.caching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Application test
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class CachingTest {
private App app;

  /**
   * Setup of application test includes: initializing DB connection and cache size/capacity.
 *  @author Suresh Mahto
   */
  @BeforeEach
public void setUp() {
    // VirtualDB (instead of MongoDB) was used in running the JUnit tests
    // to avoid Maven compilation errors. Set flag to true to run the
    // tests with MongoDB (provided that MongoDB is installed and socket
    // connection is open).
AppManager.initDb(false);
AppManager.initCacheCapacity(3);
app = new App();
  }

@Test
public void testReadAndWriteThroughStrategy() {
app.useReadAndWriteThroughStrategy();
  }

@Test
public void testReadThroughAndWriteAroundStrategy() {
app.useReadThroughAndWriteAroundStrategy();
  }

@Test
public void testReadThroughAndWriteBehindStrategy() {
app.useReadThroughAndWriteBehindStrategy();
  }

@Test
public void testCacheAsideStrategy() {
app.useCacheAsideStategy();
  }
}
