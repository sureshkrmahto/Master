package com.iluwatar.servant;

import java.util.List;

/**
 * Servant.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Servant {

public String name;

  /**
   * Constructor.
 *  @author Suresh Mahto
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
 *  @author Suresh Mahto
   */
public boolean checkIfYouWillBeHanged(List<Royalty> tableGuests) {
return tableGuests.stream().allMatch(Royalty::getMood);
  }
}
