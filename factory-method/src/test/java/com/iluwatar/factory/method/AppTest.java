package com.iluwatar.factory.method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests that Factory Method example runs without errors.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

@Test
void shouldExecuteWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
