package com.updatemethod;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class AppTest {

@Test
public void shouldExecuteApplicationWithoutException() {
assertDoesNotThrow(() -> App.main(new String[]{}));
  }
}
