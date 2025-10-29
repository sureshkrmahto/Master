package com.iluwatar.event.asynchronous;

/**
 * Type of Exception raised when the Operation being invoked is Long Running.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LongRunningEventException extends Exception {

private static final long serialVersionUID = -483423544320148809L;

public LongRunningEventException(String message) {
super(message);
  }
}
