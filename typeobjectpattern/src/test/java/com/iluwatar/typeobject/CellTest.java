package com.iluwatar.typeobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.typeobject.Candy.Type;
import org.junit.jupiter.api.Test;

/**
 * The CellTest class tests the methods in the {@link Cell} class.
 */
class CellTest {

  @Test
  void interactTest() {
    var c1 = new Candy("green jelly", "jelly", Type.CRUSHABLE_CANDY, 5);
    var c2 = new Candy("green apple", "apple", Type.REWARD_FRUIT, 10);
    var matrix = new Cell[4][4];
    matrix[0][0] = new Cell(c1, 0, 0);
    matrix[0][1] = new Cell(c1, 1, 0);
    matrix[0][2] = new Cell(c2, 2, 0);
    matrix[0][3] = new Cell(c1, 3, 0);
    var cp = new CellPool(5);
    var points1 = matrix[0][0].interact(matrix[0][1], cp, matrix);
    var points2 = matrix[0][2].interact(matrix[0][3], cp, matrix);
    assertTrue(points1 > 0 && points2 == 0);
  }

  @Test
  void crushTest() {
    var c1 = new Candy("green jelly", "jelly", Type.CRUSHABLE_CANDY, 5);
    var c2 = new Candy("purple candy", "candy", Type.CRUSHABLE_CANDY, 5);
    var matrix = new Cell[4][4];
    matrix[0][0] = new Cell(c1, 0, 0);
    matrix[1][0] = new Cell(c2, 0, 1);
    matrix[1][0].crush(new CellPool(5), matrix);
    assertEquals("green jelly", matrix[1][0].candy.name);
  }
}
