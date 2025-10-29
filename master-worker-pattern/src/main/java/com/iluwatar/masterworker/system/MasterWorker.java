package com.iluwatar.masterworker.system;

import com.iluwatar.masterworker.Input;
import com.iluwatar.masterworker.Result;
import com.iluwatar.masterworker.system.systemmaster.Master;

/**
 * The abstract MasterWorker class which contains reference to master.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public abstract class MasterWorker {
  private final Master master;

  public MasterWorker(int numOfWorkers) {
    this.master = setMaster(numOfWorkers);
  }

  abstract Master setMaster(int numOfWorkers);

  public Result<?> getResult(Input<?> input) {
    this.master.doWork(input);
    return this.master.getFinalResult();
  }
}

