package com.iluwatar.partialresponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Application test
 */
class AppTest {

  @Test
  void shouldExecuteApplicationWithoutException() {
    Assertions.assertDoesNotThrow(() -> App.main(new String[]{}));
  }

}