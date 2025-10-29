package com.iluwatar.event.asynchronous;

/**
 * Interface with listener behaviour related to Thread Completion.
 */
public interface ThreadCompleteListener {
  void completedEventHandler(final int eventId);
}
