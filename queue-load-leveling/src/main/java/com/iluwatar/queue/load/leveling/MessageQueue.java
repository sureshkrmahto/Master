package com.iluwatar.queue.load.leveling;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MessageQueue class. In this class we will create a Blocking Queue and submit/retrieve all the
 * messages from it.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class MessageQueue {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  private final BlockingQueue<Message> blkQueue;

  // Default constructor when called creates Blocking Queue object. 
  public MessageQueue() {
    this.blkQueue = new ArrayBlockingQueue<>(1024);
  }

  /**
   * All the TaskGenerator threads will call this method to insert the Messages in to the Blocking
   * Queue.
   */
  public void submitMsg(Message msg) {
    try {
      if (null != msg) {
        blkQueue.add(msg);
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
  }

  /**
   * All the messages will be retrieved by the ServiceExecutor by calling this method and process
   * them. Retrieves and removes the head of this queue, or returns null if this queue is empty.
   */
  public Message retrieveMsg() {
    try {
      return blkQueue.poll();
    } catch (Exception e) {
      LOGGER.error(e.getMessage());
    }
    return null;
  }
}
