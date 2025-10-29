package com.iluwatar.adapter;

/**
 * An adapter helps two incompatible interfaces to work together. This is the real world definition
 * for an adapter. Interfaces may be incompatible but the inner functionality should suit the need.
 * The Adapter design pattern allows otherwise incompatible classes to work together by converting
 * the interface of one class into an interface expected by the clients.
 *
 * <p>There are two variations of the Adapter pattern: The class adapter implements the adaptee's
 * interface whereas the object adapter uses composition to contain the adaptee in the adapter
 * object. This example uses the object adapter approach.
 *
 * <p>The Adapter ({@link FishingBoatAdapter}) converts the interface of the adaptee class ({@link
 * FishingBoat}) into a suitable one expected by the client ({@link RowingBoat}).
 *
 * <p>The story of this implementation is this. <br> Pirates are coming! we need a {@link
 * RowingBoat} to flee! We have a {@link FishingBoat} and our captain. We have no time to make up a
 * new ship! we need to reuse this {@link FishingBoat}. The captain needs a rowing boat which he can
 * operate. The spec is in {@link RowingBoat}. We will use the Adapter pattern to reuse {@link
 * FishingBoat}.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public final class App {

  private App() {
  }

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(final String[] args) {
    // The captain can only operate rowing boats but with adapter he is able to
    // use fishing boats as well
    var captain = new Captain(new FishingBoatAdapter());
    captain.row();
  }
}
