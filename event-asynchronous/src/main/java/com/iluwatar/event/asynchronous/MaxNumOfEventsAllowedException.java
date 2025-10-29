package com.iluwatar.event.asynchronous;

/**
 * Type of Exception raised when the max number of allowed events is exceeded.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class MaxNumOfEventsAllowedException extends Exception {

  private static final long serialVersionUID = -8430876973516292695L;

  public MaxNumOfEventsAllowedException(String message) {
    super(message);
  }
}
