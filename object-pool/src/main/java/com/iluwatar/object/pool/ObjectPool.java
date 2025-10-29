package com.iluwatar.object.pool;

import java.util.HashSet;
import java.util.Set;

/**
 * Generic object pool.
 *
 * @param <T> Type T of Object in the Pool
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class ObjectPool<T> {

private final Set<T> available = new HashSet<>();
private final Set<T> inUse = new HashSet<>();

protected abstract T create();

  /**
   * Checkout object from pool.
 *  @author Suresh Mahto
   */
public synchronized T checkOut() {
if (available.isEmpty()) {
available.add(create());
    }
var instance = available.iterator().next();
available.remove(instance);
inUse.add(instance);
return instance;
  }

public synchronized void checkIn(T instance) {
inUse.remove(instance);
available.add(instance);
  }

@Override
public synchronized String toString() {
return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
  }
}
