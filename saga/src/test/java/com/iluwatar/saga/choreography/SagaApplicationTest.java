package com.iluwatar.saga.choreography;

import com.iluwatar.saga.orchestration.SagaApplication;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


/***
 * empty test
 

 * @author Suresh Mahto


 */
/**
 * @author Suresh Mahto
 */
public class SagaApplicationTest {
  @Test
  public void shouldExecuteWithoutException() {
    assertDoesNotThrow(() -> SagaApplication.main(new String[]{}));
  }
}