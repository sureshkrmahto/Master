package com.iluwatar.semaphore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Test case for acquiring and releasing a Semaphore
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class SemaphoreTest {

@Test
public void acquireReleaseTest() {
var sphore = new Semaphore(3);

assertEquals(3, sphore.getAvailableLicenses());

for (var i = 2; i >= 0; i--) {
try {
sphore.acquire();
assertEquals(i, sphore.getAvailableLicenses());
      } catch (InterruptedException e) {
fail(e.toString());
      }
    }

for (var i = 1; i <= 3; i++) {
sphore.release();
assertEquals(i, sphore.getAvailableLicenses());
    }

sphore.release();
assertEquals(3, sphore.getAvailableLicenses());
  }
}
