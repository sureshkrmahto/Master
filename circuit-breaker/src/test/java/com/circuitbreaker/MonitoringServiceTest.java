package com.circuitbreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Monitoring Service test
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class MonitoringServiceTest {

  //long timeout, int failureThreshold, long retryTimePeriod
@Test
public void testLocalResponse() {
var monitoringService = new MonitoringService(null,null);
var response = monitoringService.localResourceResponse();
assertEquals(response, "Local Service is working");
  }

@Test
public void testDelayedRemoteResponseSuccess() {
var delayedService = new DelayedRemoteService(System.nanoTime()-2*1000*1000*1000, 2);
var delayedServiceCircuitBreaker = new DefaultCircuitBreaker(delayedService, 3000,
1,
2 * 1000 * 1000 * 1000);

var monitoringService = new MonitoringService(delayedServiceCircuitBreaker,null);
    //Set time in past to make the server work
var response = monitoringService.delayedServiceResponse();
assertEquals(response, "Delayed service is working");
  }

@Test
public void testDelayedRemoteResponseFailure() {
var delayedService = new DelayedRemoteService(System.nanoTime(), 2);
var delayedServiceCircuitBreaker = new DefaultCircuitBreaker(delayedService, 3000,
1,
2 * 1000 * 1000 * 1000);
var monitoringService = new MonitoringService(delayedServiceCircuitBreaker,null);
    //Set time as current time as initially server fails
var response = monitoringService.delayedServiceResponse();
assertEquals(response, "Delayed service is down");
  }

@Test
public void testQuickRemoteServiceResponse() {
var delayedService = new QuickRemoteService();
var delayedServiceCircuitBreaker = new DefaultCircuitBreaker(delayedService, 3000,
1,
2 * 1000 * 1000 * 1000);
var monitoringService = new MonitoringService(delayedServiceCircuitBreaker,null);
    //Set time as current time as initially server fails
var response = monitoringService.delayedServiceResponse();
assertEquals(response, "Quick Service is working");
  }
}
