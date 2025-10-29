package com.iluwatar.factorykit.app;

import com.iluwatar.factorykit.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Application Test Entrypoint
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
class AppTest {

  @Test
  void shouldExecuteApplicationWithoutException() {
    assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}

