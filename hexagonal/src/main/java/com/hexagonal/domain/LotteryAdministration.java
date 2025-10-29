package com.hexagonal.domain;

import static com.hexagonal.domain.LotteryConstants.PRIZE_AMOUNT;
import static com.hexagonal.domain.LotteryConstants.SERVICE_BANK_ACCOUNT;

import com.google.inject.Inject;
import com.hexagonal.banking.WireTransfers;
import com.hexagonal.database.LotteryTicketRepository;
import com.hexagonal.eventlog.LotteryEventLog;
import java.util.Map;

/**
 * Lottery administration implementation.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LotteryAdministration {

private final LotteryTicketRepository repository;
private final LotteryEventLog notifications;
private final WireTransfers wireTransfers;

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
  @Inject
public LotteryAdministration(LotteryTicketRepository repository, LotteryEventLog notifications,
WireTransfers wireTransfers) {
this.repository = repository;
this.notifications = notifications;
this.wireTransfers = wireTransfers;
  }

  /**
   * Get all the lottery tickets submitted for lottery.
 *  @author Suresh Mahto
   */
public Map<LotteryTicketId, LotteryTicket> getAllSubmittedTickets() {
return repository.findAll();
  }

  /**
   * Draw lottery numbers.
 *  @author Suresh Mahto
   */
public LotteryNumbers performLottery() {
var numbers = LotteryNumbers.createRandom();
var tickets = getAllSubmittedTickets();
for (var id : tickets.keySet()) {
var lotteryTicket = tickets.get(id);
var playerDetails = lotteryTicket.getPlayerDetails();
var playerAccount = playerDetails.getBankAccount();
var result = LotteryUtils.checkTicketForPrize(repository, id, numbers).getResult();
if (result == LotteryTicketCheckResult.CheckResult.WIN_PRIZE) {
if (wireTransfers.transferFunds(PRIZE_AMOUNT, SERVICE_BANK_ACCOUNT, playerAccount)) {
notifications.ticketWon(playerDetails, PRIZE_AMOUNT);
        } else {
notifications.prizeError(playerDetails, PRIZE_AMOUNT);
        }
      } else if (result == LotteryTicketCheckResult.CheckResult.NO_PRIZE) {
notifications.ticketDidNotWin(playerDetails);
      }
    }
return numbers;
  }

  /**
   * Begin new lottery round.
 *  @author Suresh Mahto
   */
public void resetLottery() {
repository.deleteAll();
  }
}
