package com.iluwatar.masterworker.system.systemworkers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.masterworker.ArrayInput;
import com.iluwatar.masterworker.ArrayUtilityMethods;
import com.iluwatar.masterworker.system.systemmaster.ArrayTransposeMaster;
import org.junit.jupiter.api.Test;

/**
 * Testing executeOperation method in {@link ArrayTransposeWorker} class.
 */

class ArrayTransposeWorkerTest {

  @Test
  void executeOperationTest() {
    var atm = new ArrayTransposeMaster(1);
    var atw = new ArrayTransposeWorker(atm, 1);
    var matrix = new int[][]{{2, 4}, {3, 5}};
    var matrixTranspose = new int[][]{{2, 3}, {4, 5}};
    var i = new ArrayInput(matrix);
    atw.setReceivedData(atm, i);
    var r = atw.executeOperation();
    assertTrue(ArrayUtilityMethods.matricesSame(r.data, matrixTranspose));
  }

}
