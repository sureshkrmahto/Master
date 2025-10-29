package com.iluwatar.pipeline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Application Test
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

@Test
void shouldExecuteApplicationWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
