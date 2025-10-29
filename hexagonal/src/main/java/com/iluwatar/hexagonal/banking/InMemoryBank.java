package com.iluwatar.hexagonal.banking;

import com.iluwatar.hexagonal.domain.LotteryConstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Banking implementation.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class InMemoryBank implements WireTransfers {

private static final Map<String, Integer> accounts = new HashMap<>();

static {
accounts
        .put(LotteryConstants.SERVICE_BANK_ACCOUNT, LotteryConstants.SERVICE_BANK_ACCOUNT_BALANCE);
  }

@Override
public void setFunds(String bankAccount, int amount) {
accounts.put(bankAccount, amount);
  }

@Override
public int getFunds(String bankAccount) {
return accounts.getOrDefault(bankAccount, 0);
  }

@Override
public boolean transferFunds(int amount, String sourceAccount, String destinationAccount) {
if (accounts.getOrDefault(sourceAccount, 0) >= amount) {
accounts.put(sourceAccount, accounts.get(sourceAccount) - amount);
accounts.put(destinationAccount, accounts.get(destinationAccount) + amount);
return true;
    } else {
return false;
    }
  }
}
