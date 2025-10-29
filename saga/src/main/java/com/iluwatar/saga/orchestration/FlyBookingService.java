package com.iluwatar.saga.orchestration;

/**
 * Class representing a service to book a fly.
 */
public class FlyBookingService extends Service<String> {
  @Override
  public String getName() {
    return "booking a Fly";
  }
}
