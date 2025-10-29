package com.model.view.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class GiantControllerTest {

  /**
   * Verify if the controller passes the health level through to the model and vice versa
 *  @author Suresh Mahto
   */
  @Test
public void testSetHealth() {
final var model = mock(GiantModel.class);
final var view = mock(GiantView.class);
final var controller = new GiantController(model, view);

verifyZeroInteractions(model, view);

for (final var health : Health.values()) {
controller.setHealth(health);
verify(model).setHealth(health);
verifyZeroInteractions(view);
    }

controller.getHealth();
    //noinspection ResultOfMethodCallIgnored
verify(model).getHealth();

verifyNoMoreInteractions(model, view);
  }

  /**
   * Verify if the controller passes the fatigue level through to the model and vice versa
 *  @author Suresh Mahto
   */
  @Test
public void testSetFatigue() {
final var model = mock(GiantModel.class);
final var view = mock(GiantView.class);
final var controller = new GiantController(model, view);

verifyZeroInteractions(model, view);

for (final var fatigue : Fatigue.values()) {
controller.setFatigue(fatigue);
verify(model).setFatigue(fatigue);
verifyZeroInteractions(view);
    }

controller.getFatigue();
    //noinspection ResultOfMethodCallIgnored
verify(model).getFatigue();

verifyNoMoreInteractions(model, view);
  }

  /**
   * Verify if the controller passes the nourishment level through to the model and vice versa
 *  @author Suresh Mahto
   */
  @Test
public void testSetNourishment() {
final var model = mock(GiantModel.class);
final var view = mock(GiantView.class);
final var controller = new GiantController(model, view);

verifyZeroInteractions(model, view);

for (final var nourishment : Nourishment.values()) {
controller.setNourishment(nourishment);
verify(model).setNourishment(nourishment);
verifyZeroInteractions(view);
    }

controller.getNourishment();
    //noinspection ResultOfMethodCallIgnored
verify(model).getNourishment();

verifyNoMoreInteractions(model, view);
  }

@Test
public void testUpdateView() {
final var model = mock(GiantModel.class);
final var view = mock(GiantView.class);
final var controller = new GiantController(model, view);

verifyZeroInteractions(model, view);

controller.updateView();
verify(view).displayGiant(model);

verifyNoMoreInteractions(model, view);
  }

}