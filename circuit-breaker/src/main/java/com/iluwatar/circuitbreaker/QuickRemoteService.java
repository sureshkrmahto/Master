package com.iluwatar.circuitbreaker;

/**
 * A quick response remote service, that responds healthy without any delay or failure.
 */
public class QuickRemoteService implements RemoteService {

  @Override
  public String call() throws RemoteServiceException {
    return "Quick Service is working";
  }
}
