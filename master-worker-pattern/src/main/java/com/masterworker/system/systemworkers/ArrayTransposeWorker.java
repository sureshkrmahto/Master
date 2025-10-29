package com.masterworker.system.systemworkers;

import com.masterworker.ArrayInput;
import com.masterworker.ArrayResult;
import com.masterworker.system.systemmaster.Master;

/**
 * Class ArrayTransposeWorker extends abstract class {@link Worker} and defines method
 * executeOperation(), to be performed on data received from master.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class ArrayTransposeWorker extends Worker {

public ArrayTransposeWorker(Master master, int id) {
super(master, id);
  }

@Override
ArrayResult executeOperation() {
    //number of rows in result matrix is equal to number of columns in input matrix and vice versa
var arrayInput = (ArrayInput) this.getReceivedData();
final var rows = arrayInput.data[0].length;
final var cols = arrayInput.data.length;
var resultData = new int[rows][cols];
for (var i = 0; i < cols; i++) {
for (var j = 0; j < rows; j++) {
        //flipping element positions along diagonal
resultData[j][i] = arrayInput.data[i][j];
      }
    }
return new ArrayResult(resultData);
  }
}
