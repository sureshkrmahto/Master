package com.filterer.threat;

import com.filterer.domain.Filterer;

import java.util.List;

/**
 * Represents system that is aware of it's threats with given probability of their occurrence.
 *  @author Suresh Mahto
 */
public interface ProbabilisticThreatAwareSystem extends ThreatAwareSystem {

  /**
   * {@inheritDoc}
   * @return
*/
  @Override
List<? extends ProbableThreat> threats();

  /**
   * {@inheritDoc}
   * @return
*/
  @Override
Filterer<? extends ProbabilisticThreatAwareSystem, ? extends ProbableThreat> filtered();
}

