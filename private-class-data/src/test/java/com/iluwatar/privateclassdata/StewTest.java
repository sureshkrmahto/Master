package com.iluwatar.privateclassdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.iluwatar.privateclassdata.utils.InMemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
public class StewTest {

  private InMemoryAppender appender;

  @BeforeEach
  public void setUp() {
    appender = new InMemoryAppender();
  }

  @AfterEach
  public void tearDown() {
    appender.stop();
  }

  /**
   * Verify if mixing the stew doesn't change the internal state
   */
  @Test
  public void testMix() {
    final var stew = new ImmutableStew(1, 2, 3, 4);
    final var expectedMessage = "Mixing the immutable stew we find: 1 potatoes, "
        + "2 carrots, 3 meat and 4 peppers";

    for (var i = 0; i < 20; i++) {
      stew.mix();
      assertEquals(expectedMessage, appender.getLastMessage());
    }

    assertEquals(20, appender.getLogSize());
  }

}
