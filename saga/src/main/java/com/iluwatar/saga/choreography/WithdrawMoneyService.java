package com.iluwatar.saga.choreography;

/**
 * Class representing a service to withdraw a money.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class WithdrawMoneyService extends Service {

public WithdrawMoneyService(ServiceDiscoveryService service) {
super(service);
  }

@Override
public String getName() {
return "withdrawing Money";
  }

@Override
public Saga process(Saga saga) {
var inValue = saga.getCurrentValue();

if (inValue.equals("bad_order")) {
LOGGER.info("The chapter '{}' has been started. But the exception has been raised."
              + "The rollback is about to start",
getName(), inValue);
saga.setCurrentStatus(Saga.ChapterResult.ROLLBACK);
return saga;
    }
return super.process(saga);
  }
}
