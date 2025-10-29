package com.eda;

import com.eda.event.UserCreatedEvent;
import com.eda.event.UserUpdatedEvent;
import com.eda.framework.Event;
import com.eda.framework.EventDispatcher;
import com.eda.handler.UserCreatedEventHandler;
import com.eda.handler.UserUpdatedEventHandler;
import com.eda.model.User;

/**
 * An event-driven architecture (EDA) is a framework that orchestrates behavior around the
 * production, detection and consumption of events as well as the responses they evoke. An event is
 * any identifiable occurrence that has significance for system hardware or software.
 *
 * <p>The example below uses an {@link EventDispatcher} to link/register {@link Event} objects to
 * their respective handlers once an {@link Event} is dispatched, it's respective handler is invoked
 * and the {@link Event} is handled accordingly.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

  /**
   * Once the {@link EventDispatcher} is initialised, handlers related to specific events have to be
   * made known to the dispatcher by registering them. In this case the {@link UserCreatedEvent} is
   * bound to the UserCreatedEventHandler, whilst the {@link UserUpdatedEvent} is bound to the
   * {@link UserUpdatedEventHandler}. The dispatcher can now be called to dispatch specific events.
   * When a user is saved, the {@link UserCreatedEvent} can be dispatched. On the other hand, when a
   * user is updated, {@link UserUpdatedEvent} can be dispatched.
 *  @author Suresh Mahto
   */
public static void main(String[] args) {

var dispatcher = new EventDispatcher();
dispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
dispatcher.registerHandler(UserUpdatedEvent.class, new UserUpdatedEventHandler());

var user = new User("iluwatar");
dispatcher.dispatch(new UserCreatedEvent(user));
dispatcher.dispatch(new UserUpdatedEvent(user));
  }

}
