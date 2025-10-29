package com.iluwatar.featuretoggle.pattern.tieredversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.featuretoggle.pattern.Service;
import com.iluwatar.featuretoggle.user.User;
import com.iluwatar.featuretoggle.user.UserGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Tiered Feature Toggle
 */
public class TieredFeatureToggleVersionTest {

  final User paidUser = new User("Jamie Coder");
  final User freeUser = new User("Alan Defect");
  final Service service = new TieredFeatureToggleVersion();

  @BeforeEach
  public void setUp() {
    UserGroup.addUserToPaidGroup(paidUser);
    UserGroup.addUserToFreeGroup(freeUser);
  }

  @Test
  public void testGetWelcomeMessageForPaidUser() {
    final var welcomeMessage = service.getWelcomeMessage(paidUser);
    final var expected = "You're amazing Jamie Coder. Thanks for paying for this awesome software.";
    assertEquals(expected, welcomeMessage);
  }

  @Test
  public void testGetWelcomeMessageForFreeUser() {
    final var welcomeMessage = service.getWelcomeMessage(freeUser);
    final var expected = "I suppose you can use this software.";
    assertEquals(expected, welcomeMessage);
  }

  @Test
  public void testIsEnhancedAlwaysTrueAsTiered() {
    assertTrue(service.isEnhanced());
  }
}
