package com.iluwatar.visitor;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Suresh Mahto
 */
public class CommanderTest extends UnitTest<Commander> {

  /**
   * Create a new test instance for the given {@link Commander}.
   */
  public CommanderTest() {
    super(Commander::new);
  }

  @Override
  void verifyVisit(Commander unit, UnitVisitor mockedVisitor) {
    verify(mockedVisitor).visitCommander(eq(unit));
  }

}