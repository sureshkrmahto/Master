package com.iluwatar.servant;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
public class QueenTest {

  @Test
  public void testNotFlirtyUncomplemented() {
    final var queen = new Queen();
    queen.setFlirtiness(false);
    queen.changeMood();
    assertFalse(queen.getMood());
  }

  @Test
  public void testNotFlirtyComplemented() {
    final var queen = new Queen();
    queen.setFlirtiness(false);
    queen.receiveCompliments();
    queen.changeMood();
    assertFalse(queen.getMood());
  }

  @Test
  public void testFlirtyUncomplemented() {
    final var queen = new Queen();
    queen.changeMood();
    assertFalse(queen.getMood());
  }

  @Test
  public void testFlirtyComplemented() {
    final var queen = new Queen();
    queen.receiveCompliments();
    queen.changeMood();
    assertTrue(queen.getMood());
  }

}