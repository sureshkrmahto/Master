package com.bytecode;

import java.util.Stack;

/**
 * Implementation of virtual machine.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class VirtualMachine {

private final Stack<Integer> stack = new Stack<>();

private final Wizard[] wizards = new Wizard[2];

  /**
   * Constructor.
 *  @author Suresh Mahto
   */
public VirtualMachine() {
for (var i = 0; i < wizards.length; i++) {
wizards[i] = new Wizard();
    }
  }

  /**
   * Executes provided bytecode.
   *
   * @param bytecode to execute
 *  @author Suresh Mahto
   */
public void execute(int[] bytecode) {
for (var i = 0; i < bytecode.length; i++) {
Instruction instruction = Instruction.getInstruction(bytecode[i]);
switch (instruction) {
case LITERAL:
          // Read the next byte from the bytecode.
int value = bytecode[++i];
stack.push(value);
break;
case SET_AGILITY:
var amount = stack.pop();
var wizard = stack.pop();
setAgility(wizard, amount);
break;
case SET_WISDOM:
amount = stack.pop();
wizard = stack.pop();
setWisdom(wizard, amount);
break;
case SET_HEALTH:
amount = stack.pop();
wizard = stack.pop();
setHealth(wizard, amount);
break;
case GET_HEALTH:
wizard = stack.pop();
stack.push(getHealth(wizard));
break;
case GET_AGILITY:
wizard = stack.pop();
stack.push(getAgility(wizard));
break;
case GET_WISDOM:
wizard = stack.pop();
stack.push(getWisdom(wizard));
break;
case ADD:
var a = stack.pop();
var b = stack.pop();
stack.push(a + b);
break;
case DIVIDE:
a = stack.pop();
b = stack.pop();
stack.push(b / a);
break;
case PLAY_SOUND:
wizard = stack.pop();
getWizards()[wizard].playSound();
break;
case SPAWN_PARTICLES:
wizard = stack.pop();
getWizards()[wizard].spawnParticles();
break;
default:
throw new IllegalArgumentException("Invalid instruction value");
      }
    }
  }

public Stack<Integer> getStack() {
return stack;
  }

public void setHealth(int wizard, int amount) {
wizards[wizard].setHealth(amount);
  }

public void setWisdom(int wizard, int amount) {
wizards[wizard].setWisdom(amount);
  }

public void setAgility(int wizard, int amount) {
wizards[wizard].setAgility(amount);
  }

public int getHealth(int wizard) {
return wizards[wizard].getHealth();
  }

public int getWisdom(int wizard) {
return wizards[wizard].getWisdom();
  }

public int getAgility(int wizard) {
return wizards[wizard].getAgility();
  }

public Wizard[] getWizards() {
return wizards;
  }
}
