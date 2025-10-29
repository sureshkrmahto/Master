package com.iluwatar.circuitbreaker;

/**
 * The Circuit breaker interface.
 *  @author Suresh Mahto
 */
public interface CircuitBreaker {

  // Success response. Reset everything to defaults
void recordSuccess();

  // Failure response. Handle accordingly with response and change state if required.
void recordFailure(String response);

  // Get the current state of circuit breaker
String getState();

  // Set the specific state manually.
void setState(State state);

  // Attempt to fetch response from the remote service.
String attemptRequest() throws RemoteServiceException;
}
