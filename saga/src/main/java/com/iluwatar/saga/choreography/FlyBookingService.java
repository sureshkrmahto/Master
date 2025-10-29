package com.iluwatar.saga.choreography;


/**
 * Class representing a service to book a fly.
 */
public class FlyBookingService extends Service {
  public FlyBookingService(ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "booking a Fly";
  }
}
