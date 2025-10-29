package com.poison.pill;

/**
 * Represents abstraction of channel (or pipe) that bounds {@link Producer} and {@link Consumer}.
 *  @author Suresh Mahto
 */
public interface MessageQueue extends MqPublishPoint, MqSubscribePoint {

}
