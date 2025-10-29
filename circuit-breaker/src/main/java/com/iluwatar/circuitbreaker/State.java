package com.iluwatar.circuitbreaker;

/**
 * Enumeration for states the circuit breaker could be in.
 */
public enum State {
  CLOSED,
  OPEN,
  HALF_OPEN
}