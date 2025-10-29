package com.iluwatar.eda.framework;

/**
 * A {@link Event} is an object with a specific type that is associated to a specific {@link
 * Handler}.
 *  @author Suresh Mahto
 */
public interface Event {

  /**
   * Returns the message type as a {@link Class} object. In this example the message type is used to
   * handle events by their type.
   *
   * @return the message type as a {@link Class}.
*/
Class<? extends Event> getType();
}
