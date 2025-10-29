package com.iluwatar.fluentinterface.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Application Test Entry
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

@Test
void shouldExecuteWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
