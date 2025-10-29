package com.iluwatar.queue.load.leveling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TaskGenerator class. Each TaskGenerator thread will be a Worker which submit's messages to the
 * queue. We need to mention the message count for each of the TaskGenerator threads.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class TaskGenerator implements Task, Runnable {


private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  // MessageQueue reference using which we will submit our messages.
private final MessageQueue msgQueue;

  // Total message count that a TaskGenerator will submit.
private final int msgCount;

  // Parameterized constructor.
public TaskGenerator(MessageQueue msgQueue, int msgCount) {
this.msgQueue = msgQueue;
this.msgCount = msgCount;
  }

  /**
   * Submit messages to the Blocking Queue.
 *  @author Suresh Mahto
   */
public void submit(Message msg) {
try {
this.msgQueue.submitMsg(msg);
    } catch (Exception e) {
LOGGER.error(e.getMessage());
    }
  }

  /**
   * Each TaskGenerator thread will submit all the messages to the Queue. After every message
   * submission TaskGenerator thread will sleep for 1 second.
 *  @author Suresh Mahto
   */
public void run() {
var count = this.msgCount;

try {
while (count > 0) {
var statusMsg = "Message-" + count + " submitted by " + Thread.currentThread().getName();
this.submit(new Message(statusMsg));

LOGGER.info(statusMsg);

        // reduce the message count.
count--;

        // Make the current thread to sleep after every Message submission.
Thread.sleep(1000);
      }
    } catch (Exception e) {
LOGGER.error(e.getMessage());
    }
  }
}