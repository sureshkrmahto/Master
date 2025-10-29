package com.poison.pill;

import com.poison.pill.Message.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for receiving and handling submitted to the queue messages.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Consumer {

private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

private final MqSubscribePoint queue;
private final String name;

public Consumer(String name, MqSubscribePoint queue) {
this.name = name;
this.queue = queue;
  }

  /**
   * Consume message.
 *  @author Suresh Mahto
   */
public void consume() {
while (true) {
try {
var msg = queue.take();
if (Message.POISON_PILL.equals(msg)) {
LOGGER.info("Consumer {} receive request to terminate.", name);
break;
        }
var sender = msg.getHeader(Headers.SENDER);
var body = msg.getBody();
LOGGER.info("Message [{}] from [{}] received by [{}]", body, sender, name);
      } catch (InterruptedException e) {
        // allow thread to exit
LOGGER.error("Exception caught.", e);
return;
      }
    }
  }
}
