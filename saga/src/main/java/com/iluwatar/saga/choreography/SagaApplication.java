package com.iluwatar.saga.choreography;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This pattern is used in distributed services to perform a group of operations atomically. This is
 * an analog of transaction in a database but in terms of microservices architecture this is
 * executed in a distributed environment
 *
 * <p>A saga is a sequence of local transactions in a certain context.
 * If one transaction fails for some reason, the saga executes compensating transactions(rollbacks)
 * to undo the impact of the preceding transactions.
 *
 * <p>In this approach, there are no mediators or orchestrators services.
 * All chapters are handled and moved by services manually.
 *
 * <p>The major difference with choreography saga is an ability to handle crashed services
 * (otherwise in choreography services very hard to prevent a saga if one of them has been crashed)
 *
 * @see com.iluwatar.saga.choreography.Saga
 * @see Service
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class SagaApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(SagaApplication.class);

  /**
   * main method.
   */
  public static void main(String[] args) {
    var sd = serviceDiscovery();
    var service = sd.findAny();
    var goodOrderSaga = service.execute(newSaga("good_order"));
    var badOrderSaga = service.execute(newSaga("bad_order"));
    LOGGER.info("orders: goodOrder is {}, badOrder is {}",
        goodOrderSaga.getResult(), badOrderSaga.getResult());

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
