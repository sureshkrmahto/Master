package com.iluwatar.event.asynchronous;

/**
 * Type of Exception raised when the Operation being invoked is Invalid.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class InvalidOperationException extends Exception {

  private static final long serialVersionUID = -6191545255213410803L;

  public InvalidOperationException(String message) {
    super(message);
  }

}
