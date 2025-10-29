package com.iluwatar.saga.orchestration;

/**
 * Class representing a service to init a new order.
 */
public class OrderService extends Service<String> {
  @Override
  public String getName() {
    return "init an order";
  }
}
