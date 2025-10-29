package com.iluwatar.bytecode;

import org.junit.jupiter.api.Test;

import static com.iluwatar.bytecode.Instruction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for {@Link VirtualMachine}
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class VirtualMachineTest {

  @Test
  public void testLiteral() {
    var bytecode = new int[2];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = 10;

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(1, vm.getStack().size());
    assertEquals(Integer.valueOf(10), vm.getStack().pop());
  }

  @Test
  public void testSetHealth() {
    var wizardNumber = 0;
    var bytecode = new int[5];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = LITERAL.getIntValue();
    bytecode[3] = 50;                        // health amount
    bytecode[4] = SET_HEALTH.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(50, vm.getWizards()[wizardNumber].getHealth());
  }

  @Test
  public void testSetAgility() {
    var wizardNumber = 0;
    var bytecode = new int[5];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = LITERAL.getIntValue();
    bytecode[3] = 50;                        // agility amount
    bytecode[4] = SET_AGILITY.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(50, vm.getWizards()[wizardNumber].getAgility());
  }

  @Test
  public void testSetWisdom() {
    var wizardNumber = 0;
    var bytecode = new int[5];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = LITERAL.getIntValue();
    bytecode[3] = 50;                        // wisdom amount
    bytecode[4] = SET_WISDOM.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(50, vm.getWizards()[wizardNumber].getWisdom());
  }

  @Test
  public void testGetHealth() {
    var wizardNumber = 0;
    var bytecode = new int[8];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = LITERAL.getIntValue();
    bytecode[3] = 50;                        // health amount
    bytecode[4] = SET_HEALTH.getIntValue();
    bytecode[5] = LITERAL.getIntValue();
    bytecode[6] = wizardNumber;
    bytecode[7] = GET_HEALTH.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(Integer.valueOf(50), vm.getStack().pop());
  }

  @Test
  public void testPlaySound() {
    var wizardNumber = 0;
    var bytecode = new int[3];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = PLAY_SOUND.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(0, vm.getStack().size());
    assertEquals(1, vm.getWizards()[0].getNumberOfPlayedSounds());
  }

  @Test
  public void testSpawnParticles() {
    var wizardNumber = 0;
    var bytecode = new int[3];
    bytecode[0] = LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = SPAWN_PARTICLES.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(0, vm.getStack().size());
    assertEquals(1, vm.getWizards()[0].getNumberOfSpawnedParticles());
  }

  @Test
  public void testInvalidInstruction() {
    var bytecode = new int[1];
    bytecode[0] = 999;
    var vm = new VirtualMachine();

    assertThrows(IllegalArgumentException.class, () -> vm.execute(bytecode));
  }
}
