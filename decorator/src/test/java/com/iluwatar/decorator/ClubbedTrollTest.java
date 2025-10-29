package com.iluwatar.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ClubbedTroll}
 */
public class ClubbedTrollTest {

  @Test
  public void testClubbedTroll() {
    // Create a normal troll first, but make sure we can spy on it later on.
    final var simpleTroll = spy(new SimpleTroll());

    // Now we want to decorate the troll to make it stronger ...
    final var clubbed = new ClubbedTroll(simpleTroll);
    assertEquals(20, clubbed.getAttackPower());
    verify(simpleTroll, times(1)).getAttackPower();

    // Check if the clubbed troll actions are delegated to the decorated troll
    clubbed.attack();
    verify(simpleTroll, times(1)).attack();

    clubbed.fleeBattle();
    verify(simpleTroll, times(1)).fleeBattle();
    verifyNoMoreInteractions(simpleTroll);
  }
}
