package com.iluwatar.masterworker;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Testing utility methods in {@link ArrayUtilityMethods} class.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
class ArrayUtilityMethodsTest {

  @Test
  void arraysSameTest() {
    var arr1 = new int[]{1, 4, 2, 6};
    var arr2 = new int[]{1, 4, 2, 6};
    assertTrue(ArrayUtilityMethods.arraysSame(arr1, arr2));
  }

  @Test
  void matricesSameTest() {
    var matrix1 = new int[][]{{1, 4, 2, 6}, {5, 8, 6, 7}};
    var matrix2 = new int[][]{{1, 4, 2, 6}, {5, 8, 6, 7}};
    assertTrue(ArrayUtilityMethods.matricesSame(matrix1, matrix2));
  }

}
