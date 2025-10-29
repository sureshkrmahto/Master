package com.iluwatar.hexagonal.domain;

/**
 * Represents lottery ticket check result.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LotteryTicketCheckResult {

  /**
   * Enumeration of Type of Outcomes of a Lottery.
 *  @author Suresh Mahto
   */
public enum CheckResult {
WIN_PRIZE,
NO_PRIZE,
TICKET_NOT_SUBMITTED
  }

private final CheckResult checkResult;
private final int prizeAmount;

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
public LotteryTicketCheckResult(CheckResult result) {
checkResult = result;
prizeAmount = 0;
  }

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
public LotteryTicketCheckResult(CheckResult result, int amount) {
checkResult = result;
prizeAmount = amount;
  }

  /**
   * Get result.
   *
   * @return check result
 *  @author Suresh Mahto
   */
public CheckResult getResult() {
return checkResult;
  }

  /**
   * Get prize amount.
   *
   * @return prize amount
 *  @author Suresh Mahto
   */
public int getPrizeAmount() {
return prizeAmount;
  }

@Override
public int hashCode() {
final var prime = 31;
var result = 1;
result = prime * result + ((checkResult == null) ? 0 : checkResult.hashCode());
result = prime * result + prizeAmount;
return result;
  }

@Override
public boolean equals(Object obj) {
if (this == obj) {
return true;
    }
if (obj == null) {
return false;
    }
if (getClass() != obj.getClass()) {
return false;
    }
var other = (LotteryTicketCheckResult) obj;
return checkResult == other.checkResult && prizeAmount == other.prizeAmount;
  }
}
