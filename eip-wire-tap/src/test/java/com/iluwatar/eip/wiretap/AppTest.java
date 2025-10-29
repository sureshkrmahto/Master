package com.iluwatar.eip.wiretap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Test for App class
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

  /**
   * Issue: Add at least one assertion to this test case.
   *
   * Solution: Inserted assertion to check whether the execution of the main method in {@link App#main(String[])}
   * throws an exception.
   */

@Test
void shouldExecuteApplicationWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
