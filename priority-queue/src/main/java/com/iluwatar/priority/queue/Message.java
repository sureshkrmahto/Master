package com.iluwatar.priority.queue;

/**
 * Message bean.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Message implements Comparable<Message> {
private final String message;
private final int priority; // define message priority in queue


public Message(String message, int priority) {
this.message = message;
this.priority = priority;
  }

@Override
public int compareTo(Message o) {
return priority - o.priority;
  }

@Override
public String toString() {
return "Message{"
        + "message='" + message + '\''
        + ", priority=" + priority
        + '}';
  }
}
