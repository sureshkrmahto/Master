package com.iluwatar.eda.event;

import com.iluwatar.eda.model.User;

/**
 * The {@link UserCreatedEvent} should should be dispatched whenever a user has been created. This
 * class can be extended to contain details about the user has been created. In this example, the
 * entire {@link User} object is passed on as data with the event.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class UserCreatedEvent extends AbstractEvent {

  private final User user;

  public UserCreatedEvent(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
