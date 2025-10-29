package com.featuretoggle.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test User Group specific feature
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class UserGroupTest {

@Test
public void testAddUserToFreeGroup() {
var user = new User("Free User");
UserGroup.addUserToFreeGroup(user);
assertFalse(UserGroup.isPaid(user));
  }

@Test
public void testAddUserToPaidGroup() {
var user = new User("Paid User");
UserGroup.addUserToPaidGroup(user);
assertTrue(UserGroup.isPaid(user));
  }

@Test
public void testAddUserToPaidWhenOnFree() {
var user = new User("Paid User");
UserGroup.addUserToFreeGroup(user);
assertThrows(IllegalArgumentException.class, () -> {
UserGroup.addUserToPaidGroup(user);
    });
  }

@Test
public void testAddUserToFreeWhenOnPaid() {
var user = new User("Free User");
UserGroup.addUserToPaidGroup(user);
assertThrows(IllegalArgumentException.class, () -> {
UserGroup.addUserToFreeGroup(user);
    });
  }
}
