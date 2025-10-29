package com.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the Strategy pattern by executing the same action with
 * different {@link DragonSlayingStrategy} implementations.
 *
 * <p>The example shows both the classic class-based approach and the Java 8+
 * lambda-based approach where behavior is supplied inline.</p>
 *  @author Suresh Mahto
 */
public class App {

private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
  
  /**
   * Program entry point.
   * 
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
    // GoF Strategy pattern
LOGGER.info("Green dragon spotted ahead!");
var dragonSlayer = new DragonSlayer(new MeleeStrategy());
dragonSlayer.goToBattle();
LOGGER.info("Red dragon emerges.");
dragonSlayer.changeStrategy(new ProjectileStrategy());
dragonSlayer.goToBattle();
LOGGER.info("Black dragon lands before you.");
dragonSlayer.changeStrategy(new SpellStrategy());
dragonSlayer.goToBattle();

    // Java 8 Strategy pattern
LOGGER.info("Green dragon spotted ahead!");
dragonSlayer = new DragonSlayer(
        () -> LOGGER.info("With your Excalibur you severe the dragon's head!"));
dragonSlayer.goToBattle();
LOGGER.info("Red dragon emerges.");
dragonSlayer.changeStrategy(() -> LOGGER.info(
        "You shoot the dragon with the magical crossbow and it falls dead on the ground!"));
dragonSlayer.goToBattle();
LOGGER.info("Black dragon lands before you.");
dragonSlayer.changeStrategy(() -> LOGGER.info(
        "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"));
dragonSlayer.goToBattle();
  }
}
