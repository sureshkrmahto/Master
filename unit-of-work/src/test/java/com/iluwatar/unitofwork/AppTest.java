package com.iluwatar.unitofwork;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * AppTest
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AppTest {

@Test
public void shouldExecuteWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
