package com.iluwatar.typeobject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.typeobject.Candy.Type;
import org.junit.jupiter.api.Test;

/**
 * The CandyGameTest class tests the methods in the {@link CandyGame} class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class CandyGameTest {

@Test
void adjacentCellsTest() {
var cg = new CandyGame(3, new CellPool(9));
var arr1 = cg.adjacentCells(0, 0);
var arr2 = cg.adjacentCells(1, 2);
var arr3 = cg.adjacentCells(1, 1);
assertTrue(arr1.size() == 2 && arr2.size() == 3 && arr3.size() == 4);
  }

@Test
void continueRoundTest() {
var matrix = new Cell[2][2];
var c1 = new Candy("green jelly", "jelly", Type.CRUSHABLE_CANDY, 5);
var c2 = new Candy("purple jelly", "jelly", Type.CRUSHABLE_CANDY, 5);
var c3 = new Candy("green apple", "apple", Type.REWARD_FRUIT, 10);
matrix[0][0] = new Cell(c1, 0, 0);
matrix[0][1] = new Cell(c2, 1, 0);
matrix[1][0] = new Cell(c3, 0, 1);
matrix[1][1] = new Cell(c2, 1, 1);
var p = new CellPool(4);
var cg = new CandyGame(2, p);
cg.cells = matrix;
var fruitInLastRow = cg.continueRound();
matrix[1][0].crush(p, matrix);
matrix[0][0] = new Cell(c3, 0, 0);
var matchingCandy = cg.continueRound();
matrix[0][1].crush(p, matrix);
matrix[0][1] = new Cell(c3, 1, 0);
var noneLeft = cg.continueRound();
assertTrue(fruitInLastRow && matchingCandy && !noneLeft);
  }

}
