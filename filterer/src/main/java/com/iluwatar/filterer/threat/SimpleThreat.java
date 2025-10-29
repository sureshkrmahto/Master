package com.iluwatar.filterer.threat;

import java.util.Objects;

/**
 * Represents a simple threat.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class SimpleThreat implements Threat {

  private final ThreatType threatType;
  private final int id;
  private final String name;

  /**
   * Constructor.
   *
   * @param threatType {@link ThreatType}.
   * @param id         threat id.
   * @param name       threat name.
   */
  public SimpleThreat(final ThreatType threatType, final int id, String name) {
    this.threatType = threatType;
    this.id = id;
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int id() {
    return id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ThreatType type() {
    return threatType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    var that = (SimpleThreat) o;
    return id == that.id
            && threatType == that.threatType
            && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(threatType, id, name);
  }

  @Override
  public String toString() {
    return "SimpleThreat{"
            + "threatType=" + threatType
            + ", id=" + id
            + ", name='" + name + '\''
            + '}';
  }
}
