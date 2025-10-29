package com.semaphore;

/**
 * Lock is an interface for a lock which can be acquired and released.
 *  @author Suresh Mahto
 */
public interface Lock {

void acquire() throws InterruptedException;

void release();

}
