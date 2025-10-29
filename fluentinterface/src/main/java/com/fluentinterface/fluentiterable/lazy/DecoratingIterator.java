package com.fluentinterface.fluentiterable.lazy;

import java.util.Iterator;

/**
 * This class is used to realize LazyFluentIterables. It decorates a given iterator. Does not
 * support consecutive hasNext() calls.
 *
 * @param <E> Iterable Collection of Elements of Type E
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class DecoratingIterator<E> implements Iterator<E> {

protected final Iterator<E> fromIterator;

private E next;

  /**
   * Creates an iterator that decorates the given iterator.
 *  @author Suresh Mahto
   */
public DecoratingIterator(Iterator<E> fromIterator) {
this.fromIterator = fromIterator;
  }

  /**
   * Precomputes and saves the next element of the Iterable. null is considered as end of data.
   *
   * @return true if a next element is available
 *  @author Suresh Mahto
   */
  @Override
public final boolean hasNext() {
next = computeNext();
return next != null;
  }

  /**
   * Returns the next element of the Iterable.
   *
   * @return the next element of the Iterable, or null if not present.
 *  @author Suresh Mahto
   */
  @Override
public final E next() {
if (next == null) {
return fromIterator.next();
    } else {
final var result = next;
next = null;
return result;
    }
  }

  /**
   * Computes the next object of the Iterable. Can be implemented to realize custom behaviour for an
   * iteration process. null is considered as end of data.
   *
   * @return the next element of the Iterable.
 *  @author Suresh Mahto
   */
public abstract E computeNext();
}
