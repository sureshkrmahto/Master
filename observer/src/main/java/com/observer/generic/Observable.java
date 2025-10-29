package com.observer.generic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Subject base class for the generic Observer variant.
 *
 * @param <S> subject type (self-type)
 * @param <O> observer type
 * @param <A> argument type passed to observers
 *  @author Suresh Mahto
 */
public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

protected final List<O> observers;

  /**
   * Creates an observable with a thread-safe observer list.
 *  @author Suresh Mahto
   */
public Observable() {
this.observers = new CopyOnWriteArrayList<>();
  }

  /**
   * Registers an observer.
   *
   * @param observer observer to add
 *  @author Suresh Mahto
   */
public void addObserver(O observer) {
this.observers.add(observer);
  }

  /**
   * Unregisters an observer.
   *
   * @param observer observer to remove
 *  @author Suresh Mahto
   */
public void removeObserver(O observer) {
this.observers.remove(observer);
  }

  /**
   * Notify observers.
 *  @author Suresh Mahto
   */
  @SuppressWarnings("unchecked")
public void notifyObservers(A argument) {
for (var observer : observers) {
observer.update((S) this, argument);
    }
  }
}
