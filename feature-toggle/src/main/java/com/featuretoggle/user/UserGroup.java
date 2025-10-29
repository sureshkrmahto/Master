package com.featuretoggle.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the lists of users of different groups paid and free. Used to demonstrate the tiered
 * example of feature toggle. Allowing certain features to be available to only certain groups of
 * users.
 *
 * @see User
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class UserGroup {

private static final List<User> freeGroup = new ArrayList<>();
private static final List<User> paidGroup = new ArrayList<>();


  /**
   * Add the passed {@link User} to the free user group list.
   *
   * @param user {@link User} to be added to the free group
   * @throws IllegalArgumentException when user is already added to the paid group
   * @see User
 *  @author Suresh Mahto
   */
public static void addUserToFreeGroup(final User user) throws IllegalArgumentException {
if (paidGroup.contains(user)) {
throw new IllegalArgumentException("User all ready member of paid group.");
    } else {
if (!freeGroup.contains(user)) {
freeGroup.add(user);
      }
    }
  }

  /**
   * Add the passed {@link User} to the paid user group list.
   *
   * @param user {@link User} to be added to the paid group
   * @throws IllegalArgumentException when the user is already added to the free group
   * @see User
 *  @author Suresh Mahto
   */
public static void addUserToPaidGroup(final User user) throws IllegalArgumentException {
if (freeGroup.contains(user)) {
throw new IllegalArgumentException("User all ready member of free group.");
    } else {
if (!paidGroup.contains(user)) {
paidGroup.add(user);
      }
    }
  }

  /**
   * Method to take a {@link User} to determine if the user is in the {@link UserGroup#paidGroup}.
   *
   * @param user {@link User} to check if they are in the {@link UserGroup#paidGroup}
   * @return true if the {@link User} is in {@link UserGroup#paidGroup}
 *  @author Suresh Mahto
   */
public static boolean isPaid(User user) {
return paidGroup.contains(user);
  }
}
