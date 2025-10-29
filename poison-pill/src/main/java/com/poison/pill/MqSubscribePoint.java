package com.poison.pill;

/**
 * Endpoint to retrieve {@link Message} from queue.
 *  @author Suresh Mahto
 */
public interface MqSubscribePoint {

Message take() throws InterruptedException;
}
