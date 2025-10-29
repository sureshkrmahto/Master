package com.iluwatar.filterer.threat;

/**
 * Represents a threat that can be detected in given system.
 */
public interface Threat {
  /**
   * Returns name of the threat.
   *
   * @return value representing name of the threat.
   */
  String name();

  /**
   * Returns unique id of the threat.
   *
   * @return value representing threat id.
   */
  int id();

  /**
   * Returns threat type.
   * @return {@link ThreatType}
   */
  ThreatType type();
}
