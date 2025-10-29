package com.hexagonal.database;

import com.hexagonal.domain.LotteryTicket;
import com.hexagonal.domain.LotteryTicketId;
import java.util.Map;
import java.util.Optional;

/**
 * Interface for accessing lottery tickets in database.
 *  @author Suresh Mahto
 */
public interface LotteryTicketRepository {

  /**
   * Find lottery ticket by id.
*/
Optional<LotteryTicket> findById(LotteryTicketId id);

  /**
   * Save lottery ticket.
*/
Optional<LotteryTicketId> save(LotteryTicket ticket);

  /**
   * Get all lottery tickets.
*/
Map<LotteryTicketId, LotteryTicket> findAll();

  /**
   * Delete all lottery tickets.
*/
void deleteAll();

}
