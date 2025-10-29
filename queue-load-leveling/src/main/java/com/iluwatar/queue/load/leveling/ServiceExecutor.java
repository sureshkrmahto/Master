package com.iluwatar.queue.load.leveling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ServiceExecuotr class. This class will pick up Messages one by one from the Blocking Queue and
 * process them.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ServiceExecutor implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  private final MessageQueue msgQueue;

  public ServiceExecutor(MessageQueue msgQueue) {
    this.msgQueue = msgQueue;
  }

  /**
   * The ServiceExecutor thread will retrieve each message and process it.
   */
  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        var msg = msgQueue.retrieveMsg();

        if (null != msg) {
          LOGGER.info(msg.toString() + " is served.");
        } else {
          LOGGER.info("Service Executor: Waiting for Messages to serve .. ");
        }

        Thread.sleep(1000);
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }
}