package com.iluwatar.bytecode;

/**
 * Representation of instructions understandable by virtual machine.
 *  @author Suresh Mahto
 */
public enum Instruction {

LITERAL(1),
SET_HEALTH(2),
SET_WISDOM(3),
SET_AGILITY(4),
PLAY_SOUND(5),
SPAWN_PARTICLES(6),
GET_HEALTH(7),
GET_AGILITY(8),
GET_WISDOM(9),
ADD(10),
DIVIDE(11);

private final int value;

Instruction(int value) {
this.value = value;
  }

public int getIntValue() {
return value;
  }

  /**
   * Converts integer value to Instruction.
   *
   * @param value value of instruction
   * @return representation of the instruction
 *  @author Suresh Mahto
   */
public static Instruction getInstruction(int value) {
for (var i = 0; i < Instruction.values().length; i++) {
if (Instruction.values()[i].getIntValue() == value) {
return Instruction.values()[i];
      }
    }
throw new IllegalArgumentException("Invalid instruction value");
  }
}
