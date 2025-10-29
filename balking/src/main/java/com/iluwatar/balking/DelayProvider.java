package com.iluwatar.balking;

import java.util.concurrent.TimeUnit;

/**
 * An interface to simulate delay while executing some work.
 *  @author Suresh Mahto
 */
public interface DelayProvider {
void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}
