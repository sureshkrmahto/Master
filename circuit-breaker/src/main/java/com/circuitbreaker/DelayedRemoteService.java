package com.circuitbreaker;

/**
 * This simulates the remote service It responds only after a certain timeout period (default set to
 * 20 seconds).
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class DelayedRemoteService implements RemoteService {

private final long serverStartTime;
private final int delay;

  /**
   * Constructor to create an instance of DelayedService, which is down for first few seconds.
   *
   * @param delay the delay after which service would behave properly, in seconds
 *  @author Suresh Mahto
   */
public DelayedRemoteService(long serverStartTime, int delay) {
this.serverStartTime = serverStartTime;
this.delay = delay;
  }

public DelayedRemoteService() {
this.serverStartTime = System.nanoTime();
this.delay = 20;
  }

  /**
   * Responds based on delay, current time and server start time if the service is down / working.
   *
   * @return The state of the service
 *  @author Suresh Mahto
   */
  @Override
public String call() throws RemoteServiceException {
var currentTime = System.nanoTime();
    //Since currentTime and serverStartTime are both in nanoseconds, we convert it to
    //seconds by diving by 10e9 and ensure floating point division by multiplying it
    //with 1.0 first. We then check if it is greater or less than specified delay and then
    //send the reply
if ((currentTime - serverStartTime) * 1.0 / (1000 * 1000 * 1000) < delay) {
      //Can use Thread.sleep() here to block and simulate a hung server
throw new RemoteServiceException("Delayed service is down");
    }
return "Delayed service is working";
  }
}
