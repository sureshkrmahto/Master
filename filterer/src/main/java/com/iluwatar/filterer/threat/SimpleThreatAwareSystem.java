package com.iluwatar.filterer.threat;

import com.google.common.collect.ImmutableList;
import com.iluwatar.filterer.domain.Filterer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
public class SimpleThreatAwareSystem implements ThreatAwareSystem {

  private final String systemId;
  private final ImmutableList<Threat> issues;

  public SimpleThreatAwareSystem(final String systemId, final List<Threat> issues) {
    this.systemId = systemId;
    this.issues = ImmutableList.copyOf(issues);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String systemId() {
    return systemId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<? extends Threat> threats() {
    return new ArrayList<>(issues);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Filterer<? extends ThreatAwareSystem, ? extends Threat> filtered() {
    return this::filteredGroup;
  }

  private ThreatAwareSystem filteredGroup(Predicate<? super Threat> predicate) {
    return new SimpleThreatAwareSystem(this.systemId, filteredItems(predicate));
  }

  private List<Threat> filteredItems(Predicate<? super Threat> predicate) {
    return this.issues.stream()
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
    var that = (SimpleThreatAwareSystem) o;
    return systemId.equals(that.systemId)
            && issues.equals(that.issues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(systemId, issues);
  }

  @Override
  public String toString() {
    return "SimpleThreatAwareSystem{"
            + "systemId='" + systemId
            + '\'' + ", issues=" + issues
            + '}';
  }
}
