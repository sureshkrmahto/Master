package com.hexagonal.domain;

import static com.hexagonal.domain.LotteryConstants.SERVICE_BANK_ACCOUNT;
import static com.hexagonal.domain.LotteryConstants.TICKET_PRIZE;

import com.google.inject.Inject;
import com.hexagonal.banking.WireTransfers;
import com.hexagonal.database.LotteryTicketRepository;
import com.hexagonal.eventlog.LotteryEventLog;
import java.util.Optional;

/**
 * Implementation for lottery service.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LotteryService {

private final LotteryTicketRepository repository;
private final LotteryEventLog notifications;
private final WireTransfers wireTransfers;

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
  @Inject
public LotteryService(LotteryTicketRepository repository, LotteryEventLog notifications,
WireTransfers wireTransfers) {
this.repository = repository;
this.notifications = notifications;
this.wireTransfers = wireTransfers;
  }

  /**
   * Submit lottery ticket to participate in the lottery.
 *  @author Suresh Mahto
   */
public Optional<LotteryTicketId> submitTicket(LotteryTicket ticket) {
var playerDetails = ticket.getPlayerDetails();
var playerAccount = playerDetails.getBankAccount();
var result = wireTransfers.transferFunds(TICKET_PRIZE, playerAccount, SERVICE_BANK_ACCOUNT);
if (!result) {
notifications.ticketSubmitError(playerDetails);
return Optional.empty();
    }
var optional = repository.save(ticket);
if (optional.isPresent()) {
notifications.ticketSubmitted(playerDetails);
    }
return optional;
  }

  /**
   * Check if lottery ticket has won.
 *  @author Suresh Mahto
   */
public LotteryTicketCheckResult checkTicketForPrize(
LotteryTicketId id,
LotteryNumbers winningNumbers
  ) {
return LotteryUtils.checkTicketForPrize(repository, id, winningNumbers);
  }
}
