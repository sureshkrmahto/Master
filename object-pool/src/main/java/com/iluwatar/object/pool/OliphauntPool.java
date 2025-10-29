package com.iluwatar.object.pool;

/**
 * Oliphaunt object pool.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class OliphauntPool extends ObjectPool<Oliphaunt> {

  @Override
  protected Oliphaunt create() {
    return new Oliphaunt();
  }
}
