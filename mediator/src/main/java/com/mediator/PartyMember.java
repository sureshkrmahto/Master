package com.mediator;

/**
 * Interface for party members interacting with {@link Party}.
 *  @author Suresh Mahto
 */
public interface PartyMember {

void joinedParty(Party party);

void partyAction(Action action);

void act(Action action);
}
