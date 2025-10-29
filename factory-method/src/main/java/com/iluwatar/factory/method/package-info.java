/**
 * Factory Method pattern example.
 *
 * <p>The {@link com.iluwatar.factory.method.Blacksmith} plays the Creator role and exposes the
 * factory method {@link com.iluwatar.factory.method.Blacksmith#manufactureWeapon(com.iluwatar.factory.method.WeaponType)}.
 * Concrete creators {@link com.iluwatar.factory.method.OrcBlacksmith} and
 * {@link com.iluwatar.factory.method.ElfBlacksmith} instantiate concrete products
 * {@link com.iluwatar.factory.method.OrcWeapon} and {@link com.iluwatar.factory.method.ElfWeapon}
 * that implement {@link com.iluwatar.factory.method.Weapon}.</p>
 */
package com.iluwatar.factory.method;
