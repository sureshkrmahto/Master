package com.business.delegate;

/**
 * Class for performing service lookups.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class BusinessLookup {

private EjbService ejbService;

private JmsService jmsService;

  /**
   * Gets service instance based on service type.
   *
   * @param serviceType Type of service instance to be returned.
   * @return Service instance.
 *  @author Suresh Mahto
   */
public BusinessService getBusinessService(ServiceType serviceType) {
if (serviceType.equals(ServiceType.EJB)) {
return ejbService;
    } else {
return jmsService;
    }
  }

public void setJmsService(JmsService jmsService) {
this.jmsService = jmsService;
  }

public void setEjbService(EjbService ejbService) {
this.ejbService = ejbService;
  }
}
