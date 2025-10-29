package com.guarded.suspension;

import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Guarded Queue is an implementation for Guarded Suspension Pattern Guarded suspension pattern is
 * used to handle a situation when you want to execute a method on an object which is not in a
 * proper state.
 *
 * @see <a href="http://java-design-patterns.com/patterns/guarded-suspension/">http://java-design-patterns.com/patterns/guarded-suspension/</a>
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GuardedQueue {
private static final Logger LOGGER = LoggerFactory.getLogger(GuardedQueue.class);
private final Queue<Integer> sourceList;

public GuardedQueue() {
this.sourceList = new LinkedList<>();
  }

  /**
   * Get the last element of the queue is exists.
   *
   * @return last element of a queue if queue is not empty
 *  @author Suresh Mahto
   */
public synchronized Integer get() {
while (sourceList.isEmpty()) {
try {
LOGGER.info("waiting");
wait();
      } catch (InterruptedException e) {
e.printStackTrace();
      }
    }
LOGGER.info("getting");
return sourceList.peek();
  }

  /**
   * Put a value in the queue.
   *
   * @param e number which we want to put to our queue
 *  @author Suresh Mahto
   */
public synchronized void put(Integer e) {
LOGGER.info("putting");
sourceList.add(e);
LOGGER.info("notifying");
notify();
  }
}
