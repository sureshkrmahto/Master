package com.caching;

/**
 * Enum class containing the four caching strategies implemented in the pattern.
 *  @author Suresh Mahto
 */
public enum CachingPolicy {
THROUGH("through"), AROUND("around"), BEHIND("behind"), ASIDE("aside");

private final String policy;

CachingPolicy(String policy) {
this.policy = policy;
  }

public String getPolicy() {
return policy;
  }
}
