package com.iluwatar.adapter;

/**
 * Adapter class. Adapts the interface of the device ({@link FishingBoat}) into {@link RowingBoat}
 * interface expected by the client ({@link Captain}).
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class FishingBoatAdapter implements RowingBoat {

private final FishingBoat boat;

public FishingBoatAdapter() {
boat = new FishingBoat();
  }

public final void row() {
boat.sail();
  }
}
