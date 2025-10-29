package com.iluwatar.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Party implementation.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class PartyImpl implements Party {

private final List<PartyMember> members;

public PartyImpl() {
members = new ArrayList<>();
  }

@Override
public void act(PartyMember actor, Action action) {
for (var member : members) {
if (!member.equals(actor)) {
member.partyAction(action);
      }
    }
  }

@Override
public void addMember(PartyMember member) {
members.add(member);
member.joinedParty(this);
  }
}
