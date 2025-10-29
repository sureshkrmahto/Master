package com.command;

/**
 * The Command pattern is a behavioral design pattern in which an object is used to encapsulate all
 * information needed to perform an action or trigger an event at a later time. This information
 * includes the method name, the object that owns the method and values for the method parameters.
 *
 * <p>Four terms always associated with the command pattern are command, receiver, invoker and
 * client. A command object (spell) knows about the receiver (target) and invokes a method of the
 * receiver. An invoker object (wizard) receives a reference to the command to be executed and
 * optionally does bookkeeping about the command execution. The invoker does not know anything
 * about how the command is executed. The client decides which commands to execute at which
 * points. To execute a command, it passes a reference of the function to the invoker object.
 *
 * <p>In other words, in this example the wizard casts spells on the goblin. The wizard keeps track
 * of the previous spells cast, so it is easy to undo them. In addition, the wizard keeps track of
 * the spells undone, so they can be redone.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var wizard = new Wizard();
var goblin = new Goblin();

goblin.printStatus();

wizard.castSpell(goblin::changeSize);
goblin.printStatus();

wizard.castSpell(goblin::changeVisibility);
goblin.printStatus();

wizard.undoLastSpell();
goblin.printStatus();

wizard.undoLastSpell();
goblin.printStatus();

wizard.redoLastSpell();
goblin.printStatus();

wizard.redoLastSpell();
goblin.printStatus();
  }
}
