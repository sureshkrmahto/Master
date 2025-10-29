package com.iluwatar.event.asynchronous;

/**
 * Custom Exception Class for Non Existent Event.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class EventDoesNotExistException extends Exception {

private static final long serialVersionUID = -3398463738273811509L;

public EventDoesNotExistException(String message) {
super(message);
  }
}
