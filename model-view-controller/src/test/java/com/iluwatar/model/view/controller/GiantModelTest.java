package com.iluwatar.model.view.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class GiantModelTest {

  /**
   * Verify if the health value is set properly though the constructor and setter
   */
  @Test
  public void testSetHealth() {
    final var model = new GiantModel(Health.HEALTHY, Fatigue.ALERT, Nourishment.SATURATED);
    assertEquals(Health.HEALTHY, model.getHealth());
    var messageFormat = "The giant looks %s, alert and saturated.";
    for (final var health : Health.values()) {
      model.setHealth(health);
      assertEquals(health, model.getHealth());
      assertEquals(String.format(messageFormat, health), model.toString());
    }
  }

  /**
   * Verify if the fatigue level is set properly though the constructor and setter
   */
  @Test
  public void testSetFatigue() {
    final var model = new GiantModel(Health.HEALTHY, Fatigue.ALERT, Nourishment.SATURATED);
    assertEquals(Fatigue.ALERT, model.getFatigue());
    var messageFormat = "The giant looks healthy, %s and saturated.";
    for (final var fatigue : Fatigue.values()) {
      model.setFatigue(fatigue);
      assertEquals(fatigue, model.getFatigue());
      assertEquals(String.format(messageFormat, fatigue), model.toString());
    }
  }

  /**
   * Verify if the nourishment level is set properly though the constructor and setter
   */
  @Test
  public void testSetNourishment() {
    final var model = new GiantModel(Health.HEALTHY, Fatigue.ALERT, Nourishment.SATURATED);
    assertEquals(Nourishment.SATURATED, model.getNourishment());
    var messageFormat = "The giant looks healthy, alert and %s.";
    for (final var nourishment : Nourishment.values()) {
      model.setNourishment(nourishment);
      assertEquals(nourishment, model.getNourishment());
      assertEquals(String.format(messageFormat, nourishment), model.toString());
    }
  }

}
