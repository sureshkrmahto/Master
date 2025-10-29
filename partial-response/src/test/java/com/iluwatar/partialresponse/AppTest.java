package com.iluwatar.partialresponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Application test
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

@Test
void shouldExecuteApplicationWithoutException() {
Assertions.assertDoesNotThrow(() -> App.main(new String[]{}));
  }

}