package com.iluwatar.filterer.threat;

/**
 * Represents threat that might be a threat with given probability.
 */
public interface ProbableThreat extends Threat {
  /**
   * Returns probability of occurrence of given threat.
   * @return probability of occurrence of given threat.
   */
  double probability();
}