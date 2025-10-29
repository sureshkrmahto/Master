/**
 * Factory Method pattern example.
 *
 * <p>The {@link com.factory.method.Blacksmith} plays the Creator role and exposes the
 * factory method {@link com.factory.method.Blacksmith#manufactureWeapon(com.factory.method.WeaponType)}.
 * Concrete creators {@link com.factory.method.OrcBlacksmith} and
 * {@link com.factory.method.ElfBlacksmith} instantiate concrete products
 * {@link com.factory.method.OrcWeapon} and {@link com.factory.method.ElfWeapon}
 * that implement {@link com.factory.method.Weapon}.</p>
 */
package com.factory.method;
