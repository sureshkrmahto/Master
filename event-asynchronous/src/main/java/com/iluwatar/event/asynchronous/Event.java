package com.iluwatar.event.asynchronous;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Each Event runs as a separate/individual thread.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Event implements IEvent, Runnable {

private static final Logger LOGGER = LoggerFactory.getLogger(Event.class);

private final int eventId;
private final int eventTime;
private final boolean isSynchronous;
private Thread thread;
private boolean isComplete = false;
private ThreadCompleteListener eventListener;

  /**
   * Constructor.
   *
   * @param eventId       event ID
   * @param eventTime     event time
   * @param isSynchronous is of synchronous type
 *  @author Suresh Mahto
   */
public Event(final int eventId, final int eventTime, final boolean isSynchronous) {
this.eventId = eventId;
this.eventTime = eventTime;
this.isSynchronous = isSynchronous;
  }

public boolean isSynchronous() {
return isSynchronous;
  }

@Override
public void start() {
thread = new Thread(this);
thread.start();
  }

@Override
public void stop() {
if (null == thread) {
return;
    }
thread.interrupt();
  }

@Override
public void status() {
if (!isComplete) {
LOGGER.info("[{}] is not done.", eventId);
    } else {
LOGGER.info("[{}] is done.", eventId);
    }
  }

@Override
public void run() {
var currentTime = System.currentTimeMillis();
var endTime = currentTime + (eventTime * 1000);
while (System.currentTimeMillis() < endTime) {
try {
Thread.sleep(1000); // Sleep for 1 second.
      } catch (InterruptedException e) {
return;
      }
    }
isComplete = true;
completed();
  }

public final void addListener(final ThreadCompleteListener listener) {
this.eventListener = listener;
  }

public final void removeListener(final ThreadCompleteListener listener) {
this.eventListener = null;
  }

private void completed() {
if (eventListener != null) {
eventListener.completedEventHandler(eventId);
    }
  }

}
