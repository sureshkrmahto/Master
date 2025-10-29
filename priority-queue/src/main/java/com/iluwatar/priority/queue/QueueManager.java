package com.iluwatar.priority.queue;

/**
 * Manage priority queue.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class QueueManager {
  /*
Priority message
   */
private final PriorityMessageQueue<Message> messagePriorityMessageQueue;

public QueueManager(int initialCapacity) {
messagePriorityMessageQueue = new PriorityMessageQueue<>(new Message[initialCapacity]);
  }

  /**
   * Publish message to queue.
 *  @author Suresh Mahto
   */
public void publishMessage(Message message) {
messagePriorityMessageQueue.add(message);
  }


  /**
   * Receive message from queue.
 *  @author Suresh Mahto
   */
public Message receiveMessage() {
if (messagePriorityMessageQueue.isEmpty()) {
return null;
    }
return messagePriorityMessageQueue.remove();
  }


}
