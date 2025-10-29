package com.iluwatar.event.aggregator;

import java.util.LinkedList;
import java.util.List;

/**
 * EventEmitter is the base class for event producers that can be observed.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class EventEmitter {

private final List<EventObserver> observers;

public EventEmitter() {
observers = new LinkedList<>();
  }

public EventEmitter(EventObserver obs) {
this();
registerObserver(obs);
  }

public final void registerObserver(EventObserver obs) {
observers.add(obs);
  }

protected void notifyObservers(Event e) {
observers.forEach(obs -> obs.onEvent(e));
  }

public abstract void timePasses(Weekday day);
}
