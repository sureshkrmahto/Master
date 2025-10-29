package com.iluwatar.event.aggregator;

/**
 * LordBaelish produces events.
 */
public class LordBaelish extends EventEmitter {

  public LordBaelish() {
  }

  public LordBaelish(EventObserver obs) {
    super(obs);
  }

  @Override
  public void timePasses(Weekday day) {
    if (day == Weekday.FRIDAY) {
      notifyObservers(Event.STARK_SIGHTED);
    }
  }
}
