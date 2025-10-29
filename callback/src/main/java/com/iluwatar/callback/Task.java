package com.iluwatar.callback;

import java.util.Optional;

/**
 * Template-method class for callback hook execution.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public abstract class Task {

  /**
   * Execute with callback.
   */
  final void executeWith(Callback callback) {
    execute();
    Optional.ofNullable(callback).ifPresent(Callback::call);
  }

  public abstract void execute();
}
