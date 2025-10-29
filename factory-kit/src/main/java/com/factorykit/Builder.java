package com.factorykit;

import java.util.function.Supplier;

/**
 * Functional interface that allows adding builder with name to the factory.
 *  @author Suresh Mahto
 */
public interface Builder {
void add(WeaponType name, Supplier<Weapon> supplier);
}
