package com.circuitbreaker;

/**
 * The service class which makes local and remote calls Uses {@link DefaultCircuitBreaker} object to
 * ensure remote calls don't use up resources.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class MonitoringService {

private final CircuitBreaker delayedService;

private final CircuitBreaker quickService;

public MonitoringService(CircuitBreaker delayedService, CircuitBreaker quickService) {
this.delayedService = delayedService;
this.quickService = quickService;
  }

  //Assumption: Local service won't fail, no need to wrap it in a circuit breaker logic
public String localResourceResponse() {
return "Local Service is working";
  }

  /**
   * Fetch response from the delayed service (with some simulated startup time).
   *
   * @return response string
 *  @author Suresh Mahto
   */
public String delayedServiceResponse() {
try {
return this.delayedService.attemptRequest();
    } catch (RemoteServiceException e) {
return e.getMessage();
    }
  }

  /**
   * Fetches response from a healthy service without any failure.
   *
   * @return response string
 *  @author Suresh Mahto
   */
public String quickServiceResponse() {
try {
return this.quickService.attemptRequest();
    } catch (RemoteServiceException e) {
return e.getMessage();
    }
  }
}