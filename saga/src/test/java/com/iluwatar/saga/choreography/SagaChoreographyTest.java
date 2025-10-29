package com.iluwatar.saga.choreography;

import org.junit.Assert;
import org.junit.Test;

/**
 * test to check choreography saga
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class SagaChoreographyTest {


@Test
public void executeTest() {
var sd = serviceDiscovery();
var service = sd.findAny();
var badOrderSaga = service.execute(newSaga("bad_order"));
var goodOrderSaga = service.execute(newSaga("good_order"));

Assert.assertEquals(badOrderSaga.getResult(), Saga.SagaResult.ROLLBACKED);
Assert.assertEquals(goodOrderSaga.getResult(), Saga.SagaResult.FINISHED);
  }

private static Saga newSaga(Object value) {
return Saga
        .create()
        .chapter("init an order").setInValue(value)
        .chapter("booking a Fly")
        .chapter("booking a Hotel")
        .chapter("withdrawing Money");
  }

private static ServiceDiscoveryService serviceDiscovery() {
var sd = new ServiceDiscoveryService();
return sd
        .discover(new OrderService(sd))
        .discover(new FlyBookingService(sd))
        .discover(new HotelBookingService(sd))
        .discover(new WithdrawMoneyService(sd));
  }
}
