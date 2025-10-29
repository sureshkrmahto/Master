package com.dependency.injection;

import javax.inject.Inject;

/**
 * GuiceWizard implements inversion of control. Its dependencies are injected through its
 * constructor by Guice framework.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class GuiceWizard implements Wizard {

private final Tobacco tobacco;

@Inject
public GuiceWizard(Tobacco tobacco) {
this.tobacco = tobacco;
  }

@Override
public void smoke() {
tobacco.smoke(this);
  }
}
