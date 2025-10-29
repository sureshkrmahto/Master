package com.iluwatar.masterworker;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class ArrayUtilityMethods has some utility methods for matrices and arrays.
 */

public class ArrayUtilityMethods {

  private static final Logger LOGGER = LoggerFactory.getLogger(ArrayUtilityMethods.class);

  private static final Random RANDOM = new Random();

  /**
   * Method arraysSame compares 2 arrays @param a1 and @param a2 and @return whether their values
   * are equal (boolean).
   */

  public static boolean arraysSame(int[] a1, int[] a2) {
    //compares if 2 arrays have the same value
    if (a1.length != a2.length) {
      return false;
    } else {
      var answer = false;
      for (var i = 0; i < a1.length; i++) {
        if (a1[i] == a2[i]) {
          answer = true;
        } else {
          answer = false;
          break;
        }
      }
      return answer;
    }
  }

  /**
   * Method matricesSame compares 2 matrices @param m1 and @param m2 and @return whether their
   * values are equal (boolean).
   */

  public static boolean matricesSame(int[][] m1, int[][] m2) {
    if (m1.length != m2.length) {
      return false;
    } else {
      var answer = false;
      for (var i = 0; i < m1.length; i++) {
        if (arraysSame(m1[i], m2[i])) {
          answer = true;
        } else {
          answer = false;
          break;
        }
      }
      return answer;
    }
  }

  /**
   * Method createRandomIntMatrix creates a random matrix of size @param rows and @param columns.
   *
   * @return it (int[][]).
   */
  public static int[][] createRandomIntMatrix(int rows, int columns) {
    var matrix = new int[rows][columns];
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < columns; j++) {
        //filling cells in matrix
        matrix[i][j] = RANDOM.nextInt(10);
      }
    }
    return matrix;
  }

  /**
   * Method printMatrix prints input matrix @param matrix.
   */

  public static void printMatrix(int[][] matrix) {
    //prints out int[][]
    for (var ints : matrix) {
      for (var j = 0; j < matrix[0].length; j++) {
        LOGGER.info(ints[j] + " ");
      }
      LOGGER.info("");
    }
  }

}
