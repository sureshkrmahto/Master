package com.iluwatar.filterer.threat;

import java.util.Objects;

/**
 * {@inheritDoc}
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class SimpleProbableThreat extends SimpleThreat implements ProbableThreat {

private final double probability;

public SimpleProbableThreat(final String name,
final int id,
final ThreatType threatType,
final double probability
  ) {
super(threatType, id, name);
this.probability = probability;
  }

  /**
   * {@inheritDoc}
 *  @author Suresh Mahto
   */
  @Override
public double probability() {
return probability;
  }

@Override
public boolean equals(Object o) {
if (this == o) {
return true;
    }
if (o == null || getClass() != o.getClass()) {
return false;
    }
if (!super.equals(o)) {
return false;
    }
var that = (SimpleProbableThreat) o;
return Double.compare(that.probability, probability) == 0;
  }

@Override
public int hashCode() {
return Objects.hash(super.hashCode(), probability);
  }

@Override
public String toString() {
return "SimpleProbableThreat{"
            + "probability=" + probability
            + "} "
            + super.toString();
  }
}
