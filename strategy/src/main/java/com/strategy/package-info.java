/**
 * Strategy pattern example.
 *
 * <p>Defines a family of algorithms, encapsulates each one, and makes them
 * interchangeable. The algorithm can vary independently from the clients that
 * use it. In this package, {@link com.strategy.DragonSlayer} acts as the context
 * and delegates the battle algorithm to a {@link com.strategy.DragonSlayingStrategy}.
 * Concrete strategies include {@link com.strategy.MeleeStrategy},
 * {@link com.strategy.ProjectileStrategy}, and
 * {@link com.strategy.SpellStrategy}. The example also demonstrates a modern
 * Java approach where lambdas can be used to supply strategies at runtime.</p>
 */
package com.strategy;
