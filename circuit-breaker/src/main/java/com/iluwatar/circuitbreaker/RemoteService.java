package com.iluwatar.circuitbreaker;

/**
 * The Remote service interface, used by {@link CircuitBreaker} for fetching response from remote
 * services.
 */
public interface RemoteService {

  //Fetch response from remote service.
  String call() throws RemoteServiceException;
}
