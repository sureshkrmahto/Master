package com.iluwatar.balking;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Washing machine class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class WashingMachine {

private static final Logger LOGGER = LoggerFactory.getLogger(WashingMachine.class);
private final DelayProvider delayProvider;
private WashingMachineState washingMachineState;

  /**
   * Creates a new instance of WashingMachine.
 *  @author Suresh Mahto
   */
public WashingMachine() {
this((interval, timeUnit, task) -> {
try {
Thread.sleep(timeUnit.toMillis(interval));
      } catch (InterruptedException ie) {
ie.printStackTrace();
      }
task.run();
    });
  }

  /**
   * Creates a new instance of WashingMachine using provided delayProvider. This constructor is used
   * only for unit testing purposes.
 *  @author Suresh Mahto
   */
public WashingMachine(DelayProvider delayProvider) {
this.delayProvider = delayProvider;
this.washingMachineState = WashingMachineState.ENABLED;
  }

public WashingMachineState getWashingMachineState() {
return washingMachineState;
  }

  /**
   * Method responsible for washing if the object is in appropriate state.
 *  @author Suresh Mahto
   */
public void wash() {
synchronized (this) {
var machineState = getWashingMachineState();
LOGGER.info("{}: Actual machine state: {}", Thread.currentThread().getName(), machineState);
if (this.washingMachineState == WashingMachineState.WASHING) {
LOGGER.error("ERROR: Cannot wash if the machine has been already washing!");
return;
      }
this.washingMachineState = WashingMachineState.WASHING;
    }
LOGGER.info("{}: Doing the washing", Thread.currentThread().getName());

this.delayProvider.executeAfterDelay(50, TimeUnit.MILLISECONDS, this::endOfWashing);
  }

  /**
   * Method responsible of ending the washing by changing machine state.
 *  @author Suresh Mahto
   */
public synchronized void endOfWashing() {
washingMachineState = WashingMachineState.ENABLED;
LOGGER.info("{}: Washing completed.", Thread.currentThread().getId());
  }

}
