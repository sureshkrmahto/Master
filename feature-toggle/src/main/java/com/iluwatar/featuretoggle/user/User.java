package com.iluwatar.featuretoggle.user;

/**
 * Used to demonstrate the purpose of the feature toggle. This class actually has nothing to do with
 * the pattern.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class User {

  private final String name;

  /**
   * Default Constructor setting the username.
   *
   * @param name {@link String} to represent the name of the user.
   */
  public User(String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   *
   * @return The {@link String} representation of the User, in this case just return the name of the
   *     user.
   */
  @Override
  public String toString() {
    return name;
  }
}
