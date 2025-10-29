package com.iluwatar.templatemethod;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
public class HalflingThiefTest {

  /**
   * Verify if the thief uses the provided stealing method
   */
  @Test
  public void testSteal() {
    final var method = mock(StealingMethod.class);
    final var thief = new HalflingThief(method);

    thief.steal();
    verify(method).steal();

    verifyNoMoreInteractions(method);
  }

  /**
   * Verify if the thief uses the provided stealing method, and the new method after changing it
   */
  @Test
  public void testChangeMethod() {
    final var initialMethod = mock(StealingMethod.class);
    final var thief = new HalflingThief(initialMethod);

    thief.steal();
    verify(initialMethod).steal();

    final var newMethod = mock(StealingMethod.class);
    thief.changeMethod(newMethod);

    thief.steal();
    verify(newMethod).steal();

    verifyNoMoreInteractions(initialMethod, newMethod);

  }
}