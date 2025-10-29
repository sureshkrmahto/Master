package com.iluwatar.priority.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test case for order of messages
 */
public class PriorityMessageQueueTest {


  @Test
  public void remove() {
    var stringPriorityMessageQueue = new PriorityMessageQueue<>(new String[2]);
    var pushMessage = "test";
    stringPriorityMessageQueue.add(pushMessage);
    assertEquals(stringPriorityMessageQueue.remove(), pushMessage);
  }

  @Test
  public void add() {
    var stringPriorityMessageQueue = new PriorityMessageQueue<>(new Integer[2]);
    stringPriorityMessageQueue.add(1);
    stringPriorityMessageQueue.add(5);
    stringPriorityMessageQueue.add(10);
    stringPriorityMessageQueue.add(3);
    assertEquals(10, (int) stringPriorityMessageQueue.remove());
  }

  @Test
  public void isEmpty() {
    var stringPriorityMessageQueue = new PriorityMessageQueue<>(new Integer[2]);
    assertTrue(stringPriorityMessageQueue.isEmpty());
    stringPriorityMessageQueue.add(1);
    stringPriorityMessageQueue.remove();
    assertTrue(stringPriorityMessageQueue.isEmpty());
  }

  @Test
  public void testEnsureSize() {
    var stringPriorityMessageQueue = new PriorityMessageQueue<>(new Integer[2]);
    assertTrue(stringPriorityMessageQueue.isEmpty());
    stringPriorityMessageQueue.add(1);
    stringPriorityMessageQueue.add(2);
    stringPriorityMessageQueue.add(2);
    stringPriorityMessageQueue.add(3);
    assertEquals(3, (int) stringPriorityMessageQueue.remove());
  }
}