package com.iluwatar.poison.pill;

import com.iluwatar.poison.pill.Message.Headers;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for producing unit of work that can be expressed as message and submitted to
 * queue.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Producer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

  private final MqPublishPoint queue;
  private final String name;
  private boolean isStopped;

  /**
   * Constructor.
   */
  public Producer(String name, MqPublishPoint queue) {
    this.name = name;
    this.queue = queue;
    this.isStopped = false;
  }

  /**
   * Send message to queue.
   */
  public void send(String body) {
    if (isStopped) {
      throw new IllegalStateException(String.format(
          "Producer %s was stopped and fail to deliver requested message [%s].", body, name));
    }
    var msg = new SimpleMessage();
    msg.addHeader(Headers.DATE, new Date().toString());
    msg.addHeader(Headers.SENDER, name);
    msg.setBody(body);

    try {
      queue.put(msg);
    } catch (InterruptedException e) {
      // allow thread to exit
      LOGGER.error("Exception caught.", e);
    }
  }

  /**
   * Stop system by sending poison pill.
   */
  public void stop() {
    isStopped = true;
    try {
      queue.put(Message.POISON_PILL);
    } catch (InterruptedException e) {
      // allow thread to exit
      LOGGER.error("Exception caught.", e);
    }
  }
}
