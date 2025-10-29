package com.iluwatar.servant;

import java.util.List;

/**
 * Servant.
 */
public class Servant {

  public String name;

  /**
   * Constructor.
   */
  public Servant(String name) {
    this.name = name;
  }

  public void feed(Royalty r) {
    r.getFed();
  }

  public void giveWine(Royalty r) {
    r.getDrink();
  }

  public void giveCompliments(Royalty r) {
    r.receiveCompliments();
  }

  /**
   * Check if we will be hanged.
   */
  public boolean checkIfYouWillBeHanged(List<Royalty> tableGuests) {
    return tableGuests.stream().allMatch(Royalty::getMood);
  }
}
