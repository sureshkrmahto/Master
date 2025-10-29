package com.iluwatar.datamapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests that Data-Mapper example runs without errors.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
final class AppTest {

  /**
   * Issue: Add at least one assertion to this test case.
   *
   * Solution: Inserted assertion to check whether the execution of the main method in {@link App#main(String[])}
   * throws an exception.
   */

@Test
void shouldExecuteApplicationWithoutException() {

assertDoesNotThrow((Executable) App::main);
  }
}
