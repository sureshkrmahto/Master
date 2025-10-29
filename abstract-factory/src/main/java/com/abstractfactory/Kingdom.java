package com.abstractfactory;


public class Kingdom {

private King king;
private Castle castle;
private Army army;

public King getKing() {
return king;
  }

public Castle getCastle() {
return castle;
  }

public Army getArmy() {
return army;
  }

public void setKing(King king) {
this.king = king;
  }

public void setCastle(Castle castle) {
this.castle = castle;
  }

public void setArmy(Army army) {
this.army = army;
  }

  /**
   * The factory of kingdom factories.
   
   * @author Suresh Mahto

 *  @author Suresh Mahto
   */
public static class FactoryMaker {

    /**
     * Enumeration for the different types of Kingdoms.
 *  @author Suresh Mahto
     */
public enum KingdomType {
ELF, ORC
    }

    /**
     * The factory method to create KingdomFactory concrete objects.
 *  @author Suresh Mahto
     */
public static KingdomFactory makeFactory(KingdomType type) {
switch (type) {
case ELF:
return new ElfKingdomFactory();
case ORC:
return new OrcKingdomFactory();
default:
throw new IllegalArgumentException("KingdomType not supported.");
      }
    }
  }
}
