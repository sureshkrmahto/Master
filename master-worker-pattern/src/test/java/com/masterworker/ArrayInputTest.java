package com.masterworker;

import static com.masterworker.ArrayUtilityMethods.matricesSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Testing divideData method in {@link ArrayInput} class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class ArrayInputTest {

@Test
void divideDataTest() {
var rows = 10;
var columns = 10;
var inputMatrix = new int[rows][columns];
var rand = new Random();
for (var i = 0; i < rows; i++) {
for (var j = 0; j < columns; j++) {
inputMatrix[i][j] = rand.nextInt(10);
      }
    }
var i = new ArrayInput(inputMatrix);
var table = i.divideData(4);
var division1 = new int[][]{inputMatrix[0], inputMatrix[1], inputMatrix[2]};
var division2 = new int[][]{inputMatrix[3], inputMatrix[4], inputMatrix[5]};
var division3 = new int[][]{inputMatrix[6], inputMatrix[7]};
var division4 = new int[][]{inputMatrix[8], inputMatrix[9]};
assertTrue(matricesSame(table.get(0).data, division1)
        && matricesSame(table.get(1).data, division2)
        && matricesSame(table.get(2).data, division3)
        && matricesSame(table.get(3).data, division4));
  }

}
