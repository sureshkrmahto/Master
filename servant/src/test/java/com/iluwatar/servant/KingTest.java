package com.iluwatar.servant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class KingTest {

@Test
public void testHungrySoberUncomplimentedKing() {
final var king = new King();
king.changeMood();
assertFalse(king.getMood());
  }

@Test
public void testFedSoberUncomplimentedKing() {
final var king = new King();
king.getFed();
king.changeMood();
assertFalse(king.getMood());
  }

@Test
public void testHungryDrunkUncomplimentedKing() {
final var king = new King();
king.getDrink();
king.changeMood();
assertFalse(king.getMood());
  }

@Test
public void testHungrySoberComplimentedKing() {
final var king = new King();
king.receiveCompliments();
king.changeMood();
assertFalse(king.getMood());
  }

@Test
public void testFedDrunkUncomplimentedKing() {
final var king = new King();
king.getFed();
king.getDrink();
king.changeMood();
assertTrue(king.getMood());
  }

@Test
public void testFedSoberComplimentedKing() {
final var king = new King();
king.getFed();
king.receiveCompliments();
king.changeMood();
assertFalse(king.getMood());
  }

@Test
public void testFedDrunkComplimentedKing() {
final var king = new King();
king.getFed();
king.getDrink();
king.receiveCompliments();
king.changeMood();
assertFalse(king.getMood());
  }

@Test
public void testHungryDrunkComplimentedKing() {
final King king = new King();
king.getDrink();
king.receiveCompliments();
king.changeMood();
assertFalse(king.getMood());
  }

}