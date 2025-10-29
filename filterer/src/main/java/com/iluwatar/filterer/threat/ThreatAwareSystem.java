package com.iluwatar.filterer.threat;

import com.iluwatar.filterer.domain.Filterer;

import java.util.List;

/**
 * Represents system that is aware of threats that are present in it.
 *  @author Suresh Mahto
 */
public interface ThreatAwareSystem {

  /**
   * Returns the system id.
   *
   * @return system id.
*/
String systemId();

  /**
   * Returns list of threats for this system.
   * @return list of threats for this system.
*/
List<? extends Threat> threats();

  /**
   * Returns the instance of {@link Filterer} helper interface that allows to covariantly
   * specify lower bound for predicate that we want to filter by.
   * @return an instance of {@link Filterer} helper interface.
*/
Filterer<? extends ThreatAwareSystem, ? extends Threat> filtered();

}
