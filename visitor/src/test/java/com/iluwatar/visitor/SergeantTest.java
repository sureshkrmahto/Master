package com.iluwatar.visitor;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class SergeantTest extends UnitTest<Sergeant> {

  /**
   * Create a new test instance for the given {@link Sergeant}.
 *  @author Suresh Mahto
   */
public SergeantTest() {
super(Sergeant::new);
  }

@Override
void verifyVisit(Sergeant unit, UnitVisitor mockedVisitor) {
verify(mockedVisitor).visitSergeant(eq(unit));
  }

}