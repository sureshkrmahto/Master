package com.hexagonal.domain;

/**
 * Immutable value object representing lottery ticket.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LotteryTicket {

private LotteryTicketId id;
private final PlayerDetails playerDetails;
private final LotteryNumbers lotteryNumbers;

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
public LotteryTicket(LotteryTicketId id, PlayerDetails details, LotteryNumbers numbers) {
this.id = id;
playerDetails = details;
lotteryNumbers = numbers;
  }

  /**
   * Get player details.
   *
   * @return player details
 *  @author Suresh Mahto
   */
public PlayerDetails getPlayerDetails() {
return playerDetails;
  }

  /**
   * Get lottery numbers.
   *
   * @return lottery numbers
 *  @author Suresh Mahto
   */
public LotteryNumbers getNumbers() {
return lotteryNumbers;
  }

  /**
   * Get ticket id.
   *
   * @return id
 *  @author Suresh Mahto
   */
public LotteryTicketId getId() {
return id;
  }

  /**
   * Set ticket id.
 *  @author Suresh Mahto
   */
public void setId(LotteryTicketId id) {
this.id = id;
  }

@Override
public String toString() {
return playerDetails.toString() + " " + lotteryNumbers.toString();
  }

@Override
public int hashCode() {
final var prime = 31;
var result = 1;
result = prime * result + ((lotteryNumbers == null) ? 0 : lotteryNumbers.hashCode());
result = prime * result + ((playerDetails == null) ? 0 : playerDetails.hashCode());
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
var other = (LotteryTicket) obj;
if (lotteryNumbers == null) {
if (other.lotteryNumbers != null) {
return false;
      }
    } else if (!lotteryNumbers.equals(other.lotteryNumbers)) {
return false;
    }
if (playerDetails == null) {
return other.playerDetails == null;
    } else {
return playerDetails.equals(other.playerDetails);
    }
  }
}
