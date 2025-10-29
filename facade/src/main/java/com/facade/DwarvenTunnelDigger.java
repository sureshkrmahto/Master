package com.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DwarvenTunnelDigger is one of the goldmine subsystems.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class DwarvenTunnelDigger extends DwarvenMineWorker {

private static final Logger LOGGER = LoggerFactory.getLogger(DwarvenTunnelDigger.class);

@Override
public void work() {
LOGGER.info("{} creates another promising tunnel.", name());
  }

@Override
public String name() {
return "Dwarven tunnel digger";
  }
}
