package com.ambassador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple Client.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Client {

private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
private final ServiceAmbassador serviceAmbassador = new ServiceAmbassador();

long useService(int value) {
var result = serviceAmbassador.doRemoteFunction(value);
LOGGER.info("Service result: " + result);
return result;
  }
}
