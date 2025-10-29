package com.iluwatar.hexagonal.database;

import com.iluwatar.hexagonal.domain.LotteryTicket;
import com.iluwatar.hexagonal.domain.LotteryTicketId;
import java.util.Map;
import java.util.Optional;

/**
 * Interface for accessing lottery tickets in database.
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
