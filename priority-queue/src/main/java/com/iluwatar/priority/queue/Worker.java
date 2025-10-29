package com.iluwatar.priority.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Message Worker.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Worker {

private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);

private final QueueManager queueManager;

public Worker(QueueManager queueManager) {
this.queueManager = queueManager;
  }

  /**
   * Keep checking queue for message.
 *  @author Suresh Mahto
   */
  @SuppressWarnings("squid:S2189")
public void run() throws Exception {
while (true) {
var message = queueManager.receiveMessage();
if (message == null) {
LOGGER.info("No Message ... waiting");
Thread.sleep(200);
      } else {
processMessage(message);
      }
    }
  }

  /**
   * Process message.
 *  @author Suresh Mahto
   */
private void processMessage(Message message) {
LOGGER.info(message.toString());
  }

}
