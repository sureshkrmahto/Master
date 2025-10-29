package com.masterworker.system;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.masterworker.ArrayInput;
import com.masterworker.ArrayResult;
import com.masterworker.ArrayUtilityMethods;
import org.junit.jupiter.api.Test;

/**
 * Testing getResult method in {@link ArrayTransposeMasterWorker} class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class ArrayTransposeMasterWorkerTest {

@Test
void getResultTest() {
var atmw = new ArrayTransposeMasterWorker();
var matrix = new int[][]{
        {1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5},
        {1, 2, 3, 4, 5}
    };
var matrixTranspose = new int[][]{
        {1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2},
        {3, 3, 3, 3, 3},
        {4, 4, 4, 4, 4},
        {5, 5, 5, 5, 5}
    };
var i = new ArrayInput(matrix);
var r = (ArrayResult) atmw.getResult(i);
assertTrue(ArrayUtilityMethods.matricesSame(r.data, matrixTranspose));
  }
}
