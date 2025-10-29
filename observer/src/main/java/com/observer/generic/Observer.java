package com.observer.generic;

/**
 * Observer.
 *
 * @param <S> Observable
 * @param <O> Observer
 * @param <A> Action
 *  @author Suresh Mahto
 */
public interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

  /**
   * Receives an update from the subject.
   *
   * @param subject the subject sending the update
   * @param argument the event payload
*/
void update(S subject, A argument);
}
