package com.filterer.threat;

import com.google.common.collect.ImmutableList;
import com.filterer.domain.Filterer;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class SimpleProbabilisticThreatAwareSystem implements ProbabilisticThreatAwareSystem {

private final String systemId;
private final ImmutableList<ProbableThreat> threats;

public SimpleProbabilisticThreatAwareSystem(
final String systemId,
final List<ProbableThreat> threats
  ) {
this.systemId = systemId;
this.threats = ImmutableList.copyOf(threats);
  }

  /**
   * {@inheritDoc}
 *  @author Suresh Mahto
   */
  @Override
public String systemId() {
return systemId;
  }

  /**
   * {@inheritDoc}
 *  @author Suresh Mahto
   */
  @Override
public List<? extends ProbableThreat> threats() {
return threats;
  }

  /**
   * {@inheritDoc}
 *  @author Suresh Mahto
   */
  @Override
public Filterer<? extends ProbabilisticThreatAwareSystem, ? extends ProbableThreat> filtered() {
return this::filteredGroup;
  }

private ProbabilisticThreatAwareSystem filteredGroup(
final Predicate<? super ProbableThreat> predicate
  ) {
return new SimpleProbabilisticThreatAwareSystem(this.systemId, filteredItems(predicate));
  }

private List<ProbableThreat> filteredItems(
final Predicate<? super ProbableThreat> predicate
  ) {
return this.threats.stream()
            .filter(predicate)
            .collect(Collectors.toList());
  }

@Override
public boolean equals(Object o) {
if (this == o) {
return true;
    }
if (o == null || getClass() != o.getClass()) {
return false;
    }
var that = (SimpleProbabilisticThreatAwareSystem) o;
return systemId.equals(that.systemId)
            && threats.equals(that.threats);
  }

@Override
public int hashCode() {
return Objects.hash(systemId, threats);
  }

@Override
public String toString() {
return "SimpleProbabilisticThreatAwareSystem{"
            + "systemId='" + systemId + '\''
            + ", threats=" + threats
            + '}';
  }
}
