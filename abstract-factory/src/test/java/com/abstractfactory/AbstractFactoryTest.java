package com.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for abstract factory.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AbstractFactoryTest {

private final App app = new App();

@Test
public void king() {
app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
final var kingdom = app.getKingdom();

final var elfKing = kingdom.getKing();
assertTrue(elfKing instanceof ElfKing);
assertEquals(ElfKing.DESCRIPTION, elfKing.getDescription());

app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
final var orcKing = kingdom.getKing();
assertTrue(orcKing instanceof OrcKing);
assertEquals(OrcKing.DESCRIPTION, orcKing.getDescription());
  }

@Test
public void castle() {
app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
final var kingdom = app.getKingdom();

final var elfCastle = kingdom.getCastle();
assertTrue(elfCastle instanceof ElfCastle);
assertEquals(ElfCastle.DESCRIPTION, elfCastle.getDescription());

app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
final var orcCastle = kingdom.getCastle();
assertTrue(orcCastle instanceof OrcCastle);
assertEquals(OrcCastle.DESCRIPTION, orcCastle.getDescription());
  }

@Test
public void army() {
app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
final var kingdom = app.getKingdom();

final var elfArmy = kingdom.getArmy();
assertTrue(elfArmy instanceof ElfArmy);
assertEquals(ElfArmy.DESCRIPTION, elfArmy.getDescription());

app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
final var orcArmy = kingdom.getArmy();
assertTrue(orcArmy instanceof OrcArmy);
assertEquals(OrcArmy.DESCRIPTION, orcArmy.getDescription());
  }

@Test
public void createElfKingdom() {
app.createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
final var kingdom = app.getKingdom();

final var king = kingdom.getKing();
final var castle = kingdom.getCastle();
final var army = kingdom.getArmy();
assertTrue(king instanceof ElfKing);
assertEquals(ElfKing.DESCRIPTION, king.getDescription());
assertTrue(castle instanceof ElfCastle);
assertEquals(ElfCastle.DESCRIPTION, castle.getDescription());
assertTrue(army instanceof ElfArmy);
assertEquals(ElfArmy.DESCRIPTION, army.getDescription());
  }

@Test
public void createOrcKingdom() {
app.createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
final var kingdom = app.getKingdom();

final var king = kingdom.getKing();
final var castle = kingdom.getCastle();
final var army = kingdom.getArmy();
assertTrue(king instanceof OrcKing);
assertEquals(OrcKing.DESCRIPTION, king.getDescription());
assertTrue(castle instanceof OrcCastle);
assertEquals(OrcCastle.DESCRIPTION, castle.getDescription());
assertTrue(army instanceof OrcArmy);
assertEquals(OrcArmy.DESCRIPTION, army.getDescription());
  }
}
