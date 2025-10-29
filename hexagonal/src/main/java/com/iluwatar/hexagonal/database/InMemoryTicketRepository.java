package com.iluwatar.hexagonal.database;

import com.iluwatar.hexagonal.domain.LotteryTicket;
import com.iluwatar.hexagonal.domain.LotteryTicketId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Mock database for lottery tickets.
 */
public class InMemoryTicketRepository implements LotteryTicketRepository {

  private static final Map<LotteryTicketId, LotteryTicket> tickets = new HashMap<>();

  @Override
  public Optional<LotteryTicket> findById(LotteryTicketId id) {
    return Optional.ofNullable(tickets.get(id));
  }

  @Override
  public Optional<LotteryTicketId> save(LotteryTicket ticket) {
    var id = new LotteryTicketId();
    tickets.put(id, ticket);
    return Optional.of(id);
  }

  @Override
  public Map<LotteryTicketId, LotteryTicket> findAll() {
    return tickets;
  }

  @Override
  public void deleteAll() {
    tickets.clear();
  }
}
