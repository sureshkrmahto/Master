package com.priority.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Check queue manager
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class QueueManagerTest {

@Test
public void publishMessage() {
var queueManager = new QueueManager(2);
var testMessage = new Message("Test Message", 1);
queueManager.publishMessage(testMessage);
var recivedMessage = queueManager.receiveMessage();
assertEquals(testMessage, recivedMessage);
  }

@Test
public void receiveMessage() {
var queueManager = new QueueManager(2);
var testMessage1 = new Message("Test Message 1", 1);
queueManager.publishMessage(testMessage1);
var testMessage2 = new Message("Test Message 2", 2);
queueManager.publishMessage(testMessage2);
var recivedMessage = queueManager.receiveMessage();
assertEquals(testMessage2, recivedMessage);
  }
}