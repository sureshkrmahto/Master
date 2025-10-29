package com.iluwatar.abstractfactory;

/**
 * KingdomFactory factory interface.
 *  @author Suresh Mahto
 */
public interface KingdomFactory {

Castle createCastle();

King createKing();

Army createArmy();

}
