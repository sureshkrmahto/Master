package com.business.delegate;

/**
 * Client utilizes BusinessDelegate to call the business tier.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Client {

private final BusinessDelegate businessDelegate;

public Client(BusinessDelegate businessDelegate) {
this.businessDelegate = businessDelegate;
  }

public void doTask() {
businessDelegate.doTask();
  }
}
