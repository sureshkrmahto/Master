package com.event.aggregator;

/**
 * Scout produces events.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Scout extends EventEmitter {

public Scout() {
  }

public Scout(EventObserver obs) {
super(obs);
  }

@Override
public void timePasses(Weekday day) {
if (day == Weekday.TUESDAY) {
notifyObservers(Event.WARSHIPS_APPROACHING);
    }
  }
}
