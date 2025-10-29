package com.circuitbreaker;

/**
 * A quick response remote service, that responds healthy without any delay or failure.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class QuickRemoteService implements RemoteService {

@Override
public String call() throws RemoteServiceException {
return "Quick Service is working";
  }
}
