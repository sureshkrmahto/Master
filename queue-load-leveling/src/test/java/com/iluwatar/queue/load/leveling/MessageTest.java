package com.iluwatar.queue.load.leveling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test case for creating and checking the Message.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class MessageTest {

  @Test
  public void messageTest() {

    // Parameterized constructor test.
    var testMsg = "Message Test";
    var msg = new Message(testMsg);
    assertEquals(testMsg, msg.getMsg());
  }
}
