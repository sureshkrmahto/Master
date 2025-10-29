package com.iluwatar.data.locality;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Test Game Application
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class ApplicationTest {

  /**
   * Issue: Add at least one assertion to this test case.
   *
   * Solution: Inserted assertion to check whether the execution of the main method in {@link Application#main(String[])}
   * throws an exception.
   */

@Test
void shouldExecuteGameApplicationWithoutException() {
assertDoesNotThrow(() -> Application.main(new String[] {}));
  }
}