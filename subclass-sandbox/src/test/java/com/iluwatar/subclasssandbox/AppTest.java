package com.iluwatar.subclasssandbox;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * App unit tests.
 */
public class AppTest {

  @Test
  public void shouldExecuteWithoutException() {
    assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
