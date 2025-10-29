package com.iluwatar.halfsynchalfasync;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 *
 * @author Suresh Mahto
 */
public class AsynchronousServiceTest {
  private AsynchronousService service;
  private AsyncTask<Object> task;

  @BeforeEach
  public void setUp() {
    service = new AsynchronousService(new LinkedBlockingQueue<>());
    task = mock(AsyncTask.class);
  }

  @Test
  public void testPerfectExecution() throws Exception {
    final var result = new Object();
    when(task.call()).thenReturn(result);
    service.execute(task);

    verify(task, timeout(2000)).onPostCall(eq(result));

    final var inOrder = inOrder(task);
    inOrder.verify(task, times(1)).onPreCall();
    inOrder.verify(task, times(1)).call();
    inOrder.verify(task, times(1)).onPostCall(eq(result));

    verifyNoMoreInteractions(task);
  }

  @Test
  public void testCallException() throws Exception {
    final var exception = new IOException();
    when(task.call()).thenThrow(exception);
    service.execute(task);

    verify(task, timeout(2000)).onError(eq(exception));

    final var inOrder = inOrder(task);
    inOrder.verify(task, times(1)).onPreCall();
    inOrder.verify(task, times(1)).call();
    inOrder.verify(task, times(1)).onError(exception);

    verifyNoMoreInteractions(task);
  }

  @Test
  public void testPreCallException() {
    final var exception = new IllegalStateException();
    doThrow(exception).when(task).onPreCall();
    service.execute(task);

    verify(task, timeout(2000)).onError(eq(exception));

    final var inOrder = inOrder(task);
    inOrder.verify(task, times(1)).onPreCall();
    inOrder.verify(task, times(1)).onError(exception);

    verifyNoMoreInteractions(task);
  }

}