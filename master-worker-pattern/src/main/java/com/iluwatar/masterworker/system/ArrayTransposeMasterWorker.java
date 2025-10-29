package com.iluwatar.masterworker.system;

import com.iluwatar.masterworker.system.systemmaster.ArrayTransposeMaster;
import com.iluwatar.masterworker.system.systemmaster.Master;

/**
 * Class ArrayTransposeMasterWorker extends abstract class {@link MasterWorker} and specifically
 * solves the problem of finding transpose of input array.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ArrayTransposeMasterWorker extends MasterWorker {

  public ArrayTransposeMasterWorker() {
    super(4);
  }

  @Override
  Master setMaster(int numOfWorkers) {
    return new ArrayTransposeMaster(numOfWorkers);
  }
}
