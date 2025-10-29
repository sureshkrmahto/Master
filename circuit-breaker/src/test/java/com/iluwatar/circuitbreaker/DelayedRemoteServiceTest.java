package com.iluwatar.circuitbreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Monitoring Service test
 */
public class DelayedRemoteServiceTest {

  /**
   * Testing immediate response of the delayed service.
   *
   * @throws RemoteServiceException
   */
  @Test
  public void testDefaultConstructor() throws RemoteServiceException {
    Assertions.assertThrows(RemoteServiceException.class, () -> {
      var obj = new DelayedRemoteService();
      obj.call();
    });
  }

  /**
   * Testing server started in past (2 seconds ago) and with a simulated delay of 1 second.
   *
   * @throws RemoteServiceException
   */
  @Test
  public void testParameterizedConstructor() throws RemoteServiceException {
      var obj = new DelayedRemoteService(System.nanoTime()-2000*1000*1000,1);
      assertEquals("Delayed service is working",obj.call());
  }
}
