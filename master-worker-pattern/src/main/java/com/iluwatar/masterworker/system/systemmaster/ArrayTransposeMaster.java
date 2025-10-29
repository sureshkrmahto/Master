package com.iluwatar.masterworker.system.systemmaster;

import com.iluwatar.masterworker.ArrayResult;
import com.iluwatar.masterworker.system.systemworkers.ArrayTransposeWorker;
import com.iluwatar.masterworker.system.systemworkers.Worker;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class ArrayTransposeMaster extends abstract class {@link Master} and contains definition of
 * aggregateData, which will obtain final result from all data obtained and for setWorkers.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class ArrayTransposeMaster extends Master {
public ArrayTransposeMaster(int numOfWorkers) {
super(numOfWorkers);
  }

@Override
ArrayList<Worker> setWorkers(int num) {
    //i+1 will be id
return IntStream.range(0, num)
        .mapToObj(i -> new ArrayTransposeWorker(this, i + 1))
        .collect(Collectors.toCollection(() -> new ArrayList<>(num)));
  }

@Override
ArrayResult aggregateData() {
    // number of rows in final result is number of rows in any of obtained results from workers
var allResultData = this.getAllResultData();
var rows = ((ArrayResult) allResultData.elements().nextElement()).data.length;
var elements = allResultData.elements();
var columns = 0; // columns = sum of number of columns in all results obtained from workers
while (elements.hasMoreElements()) {
columns += ((ArrayResult) elements.nextElement()).data[0].length;
    }
var resultData = new int[rows][columns];
var columnsDone = 0; //columns aggregated so far
var workers = this.getWorkers();
for (var i = 0; i < this.getExpectedNumResults(); i++) {
      //result obtained from ith worker
var worker = workers.get(i);
var workerId = worker.getWorkerId();
var work = ((ArrayResult) allResultData.get(workerId)).data;
for (var m = 0; m < work.length; m++) {
        //m = row number, n = columns number
System.arraycopy(work[m], 0, resultData[m], columnsDone, work[0].length);
      }
columnsDone += work[0].length;
    }
return new ArrayResult(resultData);
  }

}
