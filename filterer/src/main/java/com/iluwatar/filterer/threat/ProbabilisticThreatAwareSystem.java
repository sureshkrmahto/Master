package com.iluwatar.filterer.threat;

import com.iluwatar.filterer.domain.Filterer;

import java.util.List;

/**
 * Represents system that is aware of it's threats with given probability of their occurrence.
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

