package com.iluwatar.circuitbreaker;

/**
 * Exception thrown when {@link RemoteService} does not respond successfully.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class RemoteServiceException extends Exception {

  public RemoteServiceException(String message) {
    super(message);
  }
}
