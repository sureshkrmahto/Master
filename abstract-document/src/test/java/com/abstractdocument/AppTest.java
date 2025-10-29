package com.abstractdocument;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Simple App test
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class AppTest {

  /**
   * Issue: Add at least one assertion to this test case.
   *
   * Solution: Inserted assertion to check whether the execution of the main method in {@link App}
   * throws an exception.
   */

@Test
void shouldExecuteAppWithoutException() {
assertDoesNotThrow(() -> App.main(null));
  }

}
