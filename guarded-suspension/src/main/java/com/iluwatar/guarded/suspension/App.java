package com.iluwatar.guarded.suspension;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by robertt240 on 1/26/17.
 *
 * <p>Guarded-suspension is a concurrent design pattern for handling situation when to execute some
 * action we need condition to be satisfied.
 *
 * <p>Implementation is based on GuardedQueue, which has two methods: get and put, the condition is
 * that we cannot get from empty queue so when thread attempt to break the condition we invoke
 * Object's wait method on him and when other thread put an element to the queue he notify the
 * waiting one that now he can get from queue.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class App {
  /**
   * Example pattern execution.
   *
   * @param args - command line args
   */
  public static void main(String[] args) {
    var guardedQueue = new GuardedQueue();
    var executorService = Executors.newFixedThreadPool(3);

    //here we create first thread which is supposed to get from guardedQueue
    executorService.execute(guardedQueue::get);

    // here we wait two seconds to show that the thread which is trying
    // to get from guardedQueue will be waiting
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // now we execute second thread which will put number to guardedQueue
    // and notify first thread that it could get
    executorService.execute(() -> guardedQueue.put(20));
    executorService.shutdown();
    try {
      executorService.awaitTermination(30, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
