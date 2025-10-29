package com.iluwatar.adapter;

/**
 * The Captain uses {@link RowingBoat} to sail. <br> This is the client in the pattern.
 */
public final class Captain {

  private RowingBoat rowingBoat;

  public Captain() {
  }

  public Captain(final RowingBoat boat) {
    this.rowingBoat = boat;
  }

  void setRowingBoat(final RowingBoat boat) {
    this.rowingBoat = boat;
  }

  void row() {
    rowingBoat.row();
  }

}
