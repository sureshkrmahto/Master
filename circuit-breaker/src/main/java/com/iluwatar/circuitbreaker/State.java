package com.iluwatar.circuitbreaker;

/**
 * Enumeration for states the circuit breaker could be in.
 *  @author Suresh Mahto
 */
public enum State {
CLOSED,
OPEN,
HALF_OPEN
}