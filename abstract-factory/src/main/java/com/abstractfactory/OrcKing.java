package com.abstractfactory;

/**
 * OrcKing.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class OrcKing implements King {

static final String DESCRIPTION = "This is the Orc king!";

@Override
public String getDescription() {
return DESCRIPTION;
  }
}
