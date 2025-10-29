package com.circuitbreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.rmi.Remote;
import org.junit.jupiter.api.Test;

/**
 * Circuit Breaker test
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class DefaultCircuitBreakerTest {

  //long timeout, int failureThreshold, long retryTimePeriod
@Test
public void testEvaluateState() {
var circuitBreaker = new DefaultCircuitBreaker(null, 1, 1, 100);
    //Right now, failureCount<failureThreshold, so state should be closed
assertEquals(circuitBreaker.getState(), "CLOSED");
circuitBreaker.failureCount = 4;
circuitBreaker.lastFailureTime = System.nanoTime();
circuitBreaker.evaluateState();
    //Since failureCount>failureThreshold, and lastFailureTime is nearly equal to current time,
    //state should be half-open
assertEquals(circuitBreaker.getState(), "HALF_OPEN");
    //Since failureCount>failureThreshold, and lastFailureTime is much lesser current time,
    //state should be open
circuitBreaker.lastFailureTime = System.nanoTime() - 1000 * 1000 * 1000 * 1000;
circuitBreaker.evaluateState();
assertEquals(circuitBreaker.getState(), "OPEN");
    //Now set it back again to closed to test idempotency
circuitBreaker.failureCount = 0;
circuitBreaker.evaluateState();
assertEquals(circuitBreaker.getState(), "CLOSED");
  }

@Test
public void testSetStateForBypass() {
var circuitBreaker = new DefaultCircuitBreaker(null, 1, 1, 2000 * 1000 * 1000);
    //Right now, failureCount<failureThreshold, so state should be closed
    //Bypass it and set it to open
circuitBreaker.setState(State.OPEN);
assertEquals(circuitBreaker.getState(), "OPEN");
  }

@Test
public void testApiResponses() throws RemoteServiceException {
RemoteService mockService = new RemoteService() {
@Override
public String call() throws RemoteServiceException {
return "Remote Success";
      }
    };
var circuitBreaker = new DefaultCircuitBreaker(mockService, 1, 1, 100);
    //Call with the paramater start_time set to huge amount of time in past so that service
    //replies with "Ok". Also, state is CLOSED in start
var serviceStartTime = System.nanoTime() - 60 * 1000 * 1000 * 1000;
var response = circuitBreaker.attemptRequest();
assertEquals(response, "Remote Success");

  }
}
