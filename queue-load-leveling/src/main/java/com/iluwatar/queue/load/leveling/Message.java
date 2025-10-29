package com.iluwatar.queue.load.leveling;

/**
 * Message class with only one parameter.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Message {
private final String msg;

  // Parameter constructor.
public Message(String msg) {
this.msg = msg;
  }

  // Get Method for attribute msg.
public String getMsg() {
return msg;
  }

@Override
public String toString() {
return msg;
  }
}