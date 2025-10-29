package com.iluwatar.abstractfactory;

/**
 * OrcCastle.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class OrcCastle implements Castle {

  static final String DESCRIPTION = "This is the Orc castle!";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
