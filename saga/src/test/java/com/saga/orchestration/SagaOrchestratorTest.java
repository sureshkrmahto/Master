package com.saga.orchestration;

import org.junit.Assert;
import org.junit.Test;

/**
 * test to check general logic
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class SagaOrchestratorTest {

@Test
public void execute() {
SagaOrchestrator sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());
Saga.Result badOrder = sagaOrchestrator.execute("bad_order");
Saga.Result crashedOrder = sagaOrchestrator.execute("crashed_order");

Assert.assertEquals(badOrder, Saga.Result.ROLLBACK);
Assert.assertEquals(crashedOrder, Saga.Result.CRASHED);
  }

private static Saga newSaga() {
return Saga
        .create()
        .chapter("init an order")
        .chapter("booking a Fly")
        .chapter("booking a Hotel")
        .chapter("withdrawing Money");
  }

private static ServiceDiscoveryService serviceDiscovery() {
return
new ServiceDiscoveryService()
            .discover(new OrderService())
            .discover(new FlyBookingService())
            .discover(new HotelBookingService())
            .discover(new WithdrawMoneyService());
  }
}