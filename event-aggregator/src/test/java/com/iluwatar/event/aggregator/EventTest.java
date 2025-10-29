package com.iluwatar.event.aggregator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class EventTest {

  /**
   * Verify if every event has a non-null, non-empty description
   */
  @Test
  public void testToString() {
    Arrays.stream(Event.values()).map(Event::toString).forEach(toString -> {
      assertNotNull(toString);
      assertFalse(toString.trim().isEmpty());
    });
  }

}