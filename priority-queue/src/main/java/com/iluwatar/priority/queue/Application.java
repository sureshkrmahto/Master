package com.iluwatar.priority.queue;

/**
 * Prioritize requests sent to services so that requests with a higher priority are received and
 * processed more quickly than those of a lower priority. This pattern is useful in applications
 * that offer different service level guarantees to individual clients. Example :Send multiple
 * message with different priority to worker queue. Worker execute higher priority message first
 *
 * @see "https://docs.microsoft.com/en-us/previous-versions/msp-n-p/dn589794(v=pandp.10)"
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Application {
  /**
   * main entry.
   */
  public static void main(String[] args) throws Exception {

    var queueManager = new QueueManager(10);

    // push some message to queue
    // Low Priority message
    for (var i = 0; i < 10; i++) {
      queueManager.publishMessage(new Message("Low Message Priority", 0));
    }

    // High Priority message
    for (var i = 0; i < 10; i++) {
      queueManager.publishMessage(new Message("High Message Priority", 1));
    }

    // run worker
    var worker = new Worker(queueManager);
    worker.run();


  }
}
