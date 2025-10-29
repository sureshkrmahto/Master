package com.iluwatar.guarded.suspension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * Test for Guarded Queue
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GuardedQueueTest {
private volatile Integer value;

@Test
public void testGet() {
var g = new GuardedQueue();
var executorService = Executors.newFixedThreadPool(2);
executorService.submit(() -> value = g.get());
executorService.submit(() -> g.put(10));
executorService.shutdown();
try {
executorService.awaitTermination(30, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
e.printStackTrace();
    }
assertEquals(Integer.valueOf(10), value);
  }

@Test
public void testPut() {
var g = new GuardedQueue();
g.put(12);
assertEquals(Integer.valueOf(12), g.get());
  }

}
