package com.iluwatar.separatedinterface;

import org.junit.jupiter.api.Test;

import com.iluwatar.separatedinterface.App;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Application test.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

@Test
void shouldExecuteWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
