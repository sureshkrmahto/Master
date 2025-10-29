package com.iluwatar.filterer.domain;

import java.util.function.Predicate;

/**
 * Filterer helper interface.
 * @param <G> type of the container-like object.
 * @param <E> type of the elements contained within this container-like object.
 */
@FunctionalInterface
public interface Filterer<G, E> {
  G by(Predicate<? super E> predicate);
}