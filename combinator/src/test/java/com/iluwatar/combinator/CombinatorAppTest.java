package com.iluwatar.combinator;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CombinatorAppTest {

  /**
   * Issue: Add at least one assertion to this test case.
   *
   * Solution: Inserted assertion to check whether the execution of the main method in {@link CombinatorApp#main(String[])}
   * throws an exception.
   */

  @Test
  public void shouldExecuteApplicationWithoutException() {
    assertDoesNotThrow(() -> CombinatorApp.main(new String[]{}));
  }
}