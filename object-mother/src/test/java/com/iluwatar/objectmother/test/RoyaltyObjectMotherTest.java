package com.iluwatar.objectmother.test;

import com.iluwatar.objectmother.King;
import com.iluwatar.objectmother.Queen;
import com.iluwatar.objectmother.Royalty;
import com.iluwatar.objectmother.RoyaltyObjectMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Generation of Royalty Types using the object-mother
 */
public class RoyaltyObjectMotherTest {

  @Test
  public void unsuccessfulKingFlirt() {
    var soberUnhappyKing = RoyaltyObjectMother.createSoberUnhappyKing();
    var flirtyQueen = RoyaltyObjectMother.createFlirtyQueen();
    soberUnhappyKing.flirt(flirtyQueen);
    assertFalse(soberUnhappyKing.isHappy());
  }

  @Test
  public void queenIsBlockingFlirtCauseDrunkKing() {
    var drunkUnhappyKing = RoyaltyObjectMother.createDrunkKing();
    var notFlirtyQueen = RoyaltyObjectMother.createNotFlirtyQueen();
    drunkUnhappyKing.flirt(notFlirtyQueen);
    assertFalse(drunkUnhappyKing.isHappy());
  }

  @Test
  public void queenIsBlockingFlirt() {
    var soberHappyKing = RoyaltyObjectMother.createHappyKing();
    var notFlirtyQueen = RoyaltyObjectMother.createNotFlirtyQueen();
    soberHappyKing.flirt(notFlirtyQueen);
    assertFalse(soberHappyKing.isHappy());
  }

  @Test
  public void successfullKingFlirt() {
    var soberHappyKing = RoyaltyObjectMother.createHappyKing();
    var flirtyQueen = RoyaltyObjectMother.createFlirtyQueen();
    soberHappyKing.flirt(flirtyQueen);
    assertTrue(soberHappyKing.isHappy());
  }

  @Test
  public void testQueenType() {
    var flirtyQueen = RoyaltyObjectMother.createFlirtyQueen();
    var notFlirtyQueen = RoyaltyObjectMother.createNotFlirtyQueen();
    assertEquals(flirtyQueen.getClass(), Queen.class);
    assertEquals(notFlirtyQueen.getClass(), Queen.class);
  }

  @Test
  public void testKingType() {
    var drunkKing = RoyaltyObjectMother.createDrunkKing();
    var happyDrunkKing = RoyaltyObjectMother.createHappyDrunkKing();
    var happyKing = RoyaltyObjectMother.createHappyKing();
    var soberUnhappyKing = RoyaltyObjectMother.createSoberUnhappyKing();
    assertEquals(drunkKing.getClass(), King.class);
    assertEquals(happyDrunkKing.getClass(), King.class);
    assertEquals(happyKing.getClass(), King.class);
    assertEquals(soberUnhappyKing.getClass(), King.class);
  }
}
