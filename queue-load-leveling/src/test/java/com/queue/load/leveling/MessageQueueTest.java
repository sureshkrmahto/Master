package com.queue.load.leveling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test case for submitting and retrieving messages from Blocking Queue.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class MessageQueueTest {

@Test
public void messageQueueTest() {

var msgQueue = new MessageQueue();

    // submit message
msgQueue.submitMsg(new Message("MessageQueue Test"));

    // retrieve message
assertEquals("MessageQueue Test", msgQueue.retrieveMsg().getMsg());
  }

}
