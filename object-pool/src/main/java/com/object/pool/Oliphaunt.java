package com.object.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Oliphaunts are expensive to create.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Oliphaunt {

private static final AtomicInteger counter = new AtomicInteger(0);

private final int id;

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
public Oliphaunt() {
id = counter.incrementAndGet();
try {
Thread.sleep(1000);
    } catch (InterruptedException e) {
e.printStackTrace();
    }
  }

public int getId() {
return id;
  }

@Override
public String toString() {
return String.format("Oliphaunt id=%d", id);
  }
}
