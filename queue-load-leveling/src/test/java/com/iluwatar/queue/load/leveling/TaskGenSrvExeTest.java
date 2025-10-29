package com.iluwatar.queue.load.leveling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test case for submitting Message to Blocking Queue by TaskGenerator and retrieve the message by
 * ServiceExecutor.
 */
class TaskGenSrvExeTest {

  @Test
  void taskGeneratorTest() {
    var msgQueue = new MessageQueue();

    // Create a task generator thread with 1 job to submit.
    var taskRunnable = new TaskGenerator(msgQueue, 1);
    var taskGenThr = new Thread(taskRunnable);
    taskGenThr.start();

    assertNotNull(taskGenThr);

    // Create a service executor thread.
    var srvRunnable = new ServiceExecutor(msgQueue);
    var srvExeThr = new Thread(srvRunnable);
    srvExeThr.start();

    assertNotNull(srvExeThr);
  }

}
