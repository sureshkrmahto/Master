package com.iluwatar.callback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Add a field as a counter. Every time the callback method is called increment this field. Unit
 * test checks that the field is being incremented.
 * <p>
 * Could be done with mock objects as well where the call method call is verified.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class CallbackTest {

private Integer callingCount = 0;

@Test
public void test() {
Callback callback = () -> callingCount++;

var task = new SimpleTask();

assertEquals(Integer.valueOf(0), callingCount, "Initial calling count of 0");

task.executeWith(callback);

assertEquals(Integer.valueOf(1), callingCount, "Callback called once");

task.executeWith(callback);

assertEquals(Integer.valueOf(2), callingCount, "Callback called twice");

  }
}
