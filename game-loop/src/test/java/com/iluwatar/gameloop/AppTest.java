package com.iluwatar.gameloop;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * App unit test class.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AppTest {

@Test
public void shouldExecuteApplicationWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }

}
