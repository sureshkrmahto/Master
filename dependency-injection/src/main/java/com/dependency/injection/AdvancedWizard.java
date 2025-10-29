package com.dependency.injection;

/**
 * AdvancedWizard implements inversion of control. It depends on abstraction that can be injected
 * through its constructor.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AdvancedWizard implements Wizard {

private final Tobacco tobacco;

public AdvancedWizard(Tobacco tobacco) {
this.tobacco = tobacco;
  }

@Override
public void smoke() {
tobacco.smoke(this);
  }
}
