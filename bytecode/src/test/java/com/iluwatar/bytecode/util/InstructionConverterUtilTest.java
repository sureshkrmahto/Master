package com.iluwatar.bytecode.util;

import com.iluwatar.bytecode.Instruction;
import com.iluwatar.bytecode.util.InstructionConverterUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@Link InstructionConverterUtil}
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class InstructionConverterUtilTest {
  @Test
  public void testEmptyInstruction() {
    var instruction = "";

    var bytecode = InstructionConverterUtil.convertToByteCode(instruction);

    Assertions.assertEquals(0, bytecode.length);
  }

  @Test
  public void testInstructions() {
    var instructions = "LITERAL 35 SET_HEALTH SET_WISDOM SET_AGILITY PLAY_SOUND"
        + " SPAWN_PARTICLES GET_HEALTH ADD DIVIDE";

    var bytecode = InstructionConverterUtil.convertToByteCode(instructions);

    Assertions.assertEquals(10, bytecode.length);
    Assertions.assertEquals(Instruction.LITERAL.getIntValue(), bytecode[0]);
    Assertions.assertEquals(35, bytecode[1]);
    Assertions.assertEquals(Instruction.SET_HEALTH.getIntValue(), bytecode[2]);
    Assertions.assertEquals(Instruction.SET_WISDOM.getIntValue(), bytecode[3]);
    Assertions.assertEquals(Instruction.SET_AGILITY.getIntValue(), bytecode[4]);
    Assertions.assertEquals(Instruction.PLAY_SOUND.getIntValue(), bytecode[5]);
    Assertions.assertEquals(Instruction.SPAWN_PARTICLES.getIntValue(), bytecode[6]);
    Assertions.assertEquals(Instruction.GET_HEALTH.getIntValue(), bytecode[7]);
    Assertions.assertEquals(Instruction.ADD.getIntValue(), bytecode[8]);
    Assertions.assertEquals(Instruction.DIVIDE.getIntValue(), bytecode[9]);
  }

}
