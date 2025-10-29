package com.event.aggregator;

/**
 * Observers of events implement this interface.
 *  @author Suresh Mahto
 */
public interface EventObserver {

void onEvent(Event e);

}
