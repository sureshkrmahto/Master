package com.iluwatar.featuretoggle.pattern.propertiesversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.featuretoggle.user.User;
import java.util.Properties;
import org.junit.jupiter.api.Test;

/**
 * Test Properties Toggle
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class PropertiesFeatureToggleVersionTest {

  @Test
  public void testNullPropertiesPassed() {
    assertThrows(IllegalArgumentException.class, () -> {
      new PropertiesFeatureToggleVersion(null);
    });
  }

  @Test
  public void testNonBooleanProperty() {
    assertThrows(IllegalArgumentException.class, () -> {
      final var properties = new Properties();
      properties.setProperty("enhancedWelcome", "Something");
      new PropertiesFeatureToggleVersion(properties);
    });
  }

  @Test
  public void testFeatureTurnedOn() {
    final var properties = new Properties();
    properties.put("enhancedWelcome", true);
    var service = new PropertiesFeatureToggleVersion(properties);
    assertTrue(service.isEnhanced());
    final var welcomeMessage = service.getWelcomeMessage(new User("Jamie No Code"));
    assertEquals("Welcome Jamie No Code. You're using the enhanced welcome message.", welcomeMessage);
  }

  @Test
  public void testFeatureTurnedOff() {
    final var properties = new Properties();
    properties.put("enhancedWelcome", false);
    var service = new PropertiesFeatureToggleVersion(properties);
    assertFalse(service.isEnhanced());
    final var welcomeMessage = service.getWelcomeMessage(new User("Jamie No Code"));
    assertEquals("Welcome to the application.", welcomeMessage);
  }
}
