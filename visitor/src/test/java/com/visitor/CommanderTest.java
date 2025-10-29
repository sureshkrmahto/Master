package com.visitor;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class CommanderTest extends UnitTest<Commander> {

  /**
   * Create a new test instance for the given {@link Commander}.
 *  @author Suresh Mahto
   */
public CommanderTest() {
super(Commander::new);
  }

@Override
void verifyVisit(Commander unit, UnitVisitor mockedVisitor) {
verify(mockedVisitor).visitCommander(eq(unit));
  }

}