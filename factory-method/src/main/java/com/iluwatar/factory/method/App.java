package com.iluwatar.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the Factory Method pattern: the client depends on an abstract
 * creator ({@link Blacksmith}) and remains agnostic of the concrete products
 * being created.
 *
 * <p>The concrete creators {@link OrcBlacksmith} and {@link ElfBlacksmith}
 * manufacture different {@link Weapon} variants through the same factory
 * method.</p>
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  private final Blacksmith blacksmith;
  
  /**
   * Creates an instance of <code>App</code> which will use <code>blacksmith</code> to manufacture 
   * the weapons for war.
   * <code>App</code> is unaware which concrete implementation of {@link Blacksmith} it is using.
   * The decision of which blacksmith implementation to use may depend on configuration, or
   * the type of rival in war.
   * @param blacksmith a non-null implementation of blacksmith
   */
  public App(Blacksmith blacksmith) {
    this.blacksmith = blacksmith;
  }
  
  /**
   * Program entry point.
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    // Lets go to war with Orc weapons
    var app = new App(new OrcBlacksmith());
    app.manufactureWeapons();
    
    // Lets go to war with Elf weapons
    app = new App(new ElfBlacksmith());
    app.manufactureWeapons();
  }
  
  private void manufactureWeapons() {
    var weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
    LOGGER.info(weapon.toString());
    weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
    LOGGER.info(weapon.toString());
  }
}
