package com.iluwatar.masterworker.system.systemmaster;

import com.iluwatar.masterworker.Input;
import com.iluwatar.masterworker.Result;
import com.iluwatar.masterworker.system.systemworkers.Worker;
import java.util.Hashtable;
import java.util.List;

/**
 * The abstract Master class which contains private fields numOfWorkers (number of workers), workers
 * (arraylist of workers), expectedNumResults (number of divisions of input data, same as expected
 * number of results), allResultData (hashtable of results obtained from workers, mapped by their
 * ids) and finalResult (aggregated from allResultData).
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Master {
private final int numOfWorkers;
private final List<Worker> workers;
private final Hashtable<Integer, Result<?>> allResultData;
private int expectedNumResults;
private Result<?> finalResult;

Master(int numOfWorkers) {
this.numOfWorkers = numOfWorkers;
this.workers = setWorkers(numOfWorkers);
this.expectedNumResults = 0;
this.allResultData = new Hashtable<>(numOfWorkers);
this.finalResult = null;
  }

public Result<?> getFinalResult() {
return this.finalResult;
  }

Hashtable<Integer, Result<?>> getAllResultData() {
return this.allResultData;
  }

int getExpectedNumResults() {
return this.expectedNumResults;
  }

List<Worker> getWorkers() {
return this.workers;
  }

abstract List<Worker> setWorkers(int num);

public void doWork(Input<?> input) {
divideWork(input);
  }

private void divideWork(Input<?> input) {
var dividedInput = input.divideData(numOfWorkers);
if (dividedInput != null) {
this.expectedNumResults = dividedInput.size();
for (var i = 0; i < this.expectedNumResults; i++) {
        //ith division given to ith worker in this.workers
this.workers.get(i).setReceivedData(this, dividedInput.get(i));
this.workers.get(i).start();
      }
for (var i = 0; i < this.expectedNumResults; i++) {
try {
this.workers.get(i).join();
        } catch (InterruptedException e) {
System.err.println("Error while executing thread");
        }
      }
    }
  }

public void receiveData(Result<?> data, Worker w) {
    //check if can receive..if yes:
collectResult(data, w.getWorkerId());
  }

private void collectResult(Result<?> data, int workerId) {
this.allResultData.put(workerId, data);
if (this.allResultData.size() == this.expectedNumResults) {
      //all data received
this.finalResult = aggregateData();
    }
  }

abstract Result<?> aggregateData();
}
