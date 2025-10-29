package com.business.delegate;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests that Business Delegate example runs without errors.
 
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
void shouldExecuteApplicationWithoutException() {

assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
