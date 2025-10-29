package com.semaphore;

/**
 * Semaphore is an implementation of a semaphore lock.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Semaphore implements Lock {

private final int licenses;
  /**
   * The number of concurrent resource accesses which are allowed.
 *  @author Suresh Mahto
   */
private int counter;

public Semaphore(int licenses) {
this.licenses = licenses;
this.counter = licenses;
  }

  /**
   * Returns the number of licenses managed by the Semaphore.
 *  @author Suresh Mahto
   */
public int getNumLicenses() {
return licenses;
  }

  /**
   * Returns the number of available licenses.
 *  @author Suresh Mahto
   */
public int getAvailableLicenses() {
return counter;
  }

  /**
   * Method called by a thread to acquire the lock. If there are no resources available this will
   * wait until the lock has been released to re-attempt the acquire.
 *  @author Suresh Mahto
   */
public synchronized void acquire() throws InterruptedException {
while (counter == 0) {
wait();
    }
counter = counter - 1;
  }

  /**
   * Method called by a thread to release the lock.
 *  @author Suresh Mahto
   */
public synchronized void release() {
if (counter < licenses) {
counter = counter + 1;
notify();
    }
  }

}
