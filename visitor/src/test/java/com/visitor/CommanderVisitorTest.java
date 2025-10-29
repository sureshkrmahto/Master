package com.visitor;

import java.util.Optional;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class CommanderVisitorTest extends VisitorTest<CommanderVisitor> {

  /**
   * Create a new test instance for the given visitor.
 *  @author Suresh Mahto
   */
public CommanderVisitorTest() {
super(
new CommanderVisitor(),
Optional.of("Good to see you commander"),
Optional.empty(),
Optional.empty()
    );
  }

}
