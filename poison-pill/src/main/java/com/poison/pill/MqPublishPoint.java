package com.poison.pill;

/**
 * Endpoint to publish {@link Message} to queue.
 *  @author Suresh Mahto
 */
public interface MqPublishPoint {

void put(Message msg) throws InterruptedException;
}
