package com.event.asynchronous;

/**
 * Interface with listener behaviour related to Thread Completion.
 *  @author Suresh Mahto
 */
public interface ThreadCompleteListener {
void completedEventHandler(final int eventId);
}
