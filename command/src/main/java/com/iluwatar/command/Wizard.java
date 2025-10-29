package com.iluwatar.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Wizard is the invoker of the commands.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Wizard {

private final Deque<Runnable> undoStack = new LinkedList<>();
private final Deque<Runnable> redoStack = new LinkedList<>();

public Wizard() {
  }

  /**
   * Cast spell.
 *  @author Suresh Mahto
   */
public void castSpell(Runnable runnable) {
runnable.run();
undoStack.offerLast(runnable);
  }

  /**
   * Undo last spell.
 *  @author Suresh Mahto
   */
public void undoLastSpell() {
if (!undoStack.isEmpty()) {
var previousSpell = undoStack.pollLast();
redoStack.offerLast(previousSpell);
previousSpell.run();
    }
  }

  /**
   * Redo last spell.
 *  @author Suresh Mahto
   */
public void redoLastSpell() {
if (!redoStack.isEmpty()) {
var previousSpell = redoStack.pollLast();
undoStack.offerLast(previousSpell);
previousSpell.run();
    }
  }

@Override
public String toString() {
return "Wizard";
  }
}
