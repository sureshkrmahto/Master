package com.iluwatar.saga.orchestration;

/**
 * Class representing a service to withdraw a money.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class WithdrawMoneyService extends Service<String> {
@Override
public String getName() {
return "withdrawing Money";
  }

@Override
public ChapterResult<String> process(String value) {
if (value.equals("bad_order") || value.equals("crashed_order")) {
LOGGER.info("The chapter '{}' has been started. But the exception has been raised."
              + "The rollback is about to start",
getName(), value);
return ChapterResult.failure(value);
    }
return super.process(value);
  }
}
