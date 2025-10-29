package com.iluwatar.balking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link WashingMachine}
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class WashingMachineTest {

private final FakeDelayProvider fakeDelayProvider = new FakeDelayProvider();


@Test
void wash() {
var washingMachine = new WashingMachine(fakeDelayProvider);

washingMachine.wash();
washingMachine.wash();

var machineStateGlobal = washingMachine.getWashingMachineState();

fakeDelayProvider.task.run();

    // washing machine remains in washing state
assertEquals(WashingMachineState.WASHING, machineStateGlobal);

    // washing machine goes back to enabled state
assertEquals(WashingMachineState.ENABLED, washingMachine.getWashingMachineState());
  }

@Test
void endOfWashing() {
var washingMachine = new WashingMachine();
washingMachine.wash();
assertEquals(WashingMachineState.ENABLED, washingMachine.getWashingMachineState());
  }

private static class FakeDelayProvider implements DelayProvider {
private Runnable task;

@Override
public void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task) {
this.task = task;
    }
  }
}