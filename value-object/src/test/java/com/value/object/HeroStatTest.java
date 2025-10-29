package com.value.object;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

/**
 * Unit test for HeroStat.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class HeroStatTest {

  /**
   * Tester for equals() and hashCode() methods of a class. Using guava's EqualsTester.
   *
   * @see <a href="http://static.javadoc.io/com.google.guava/guava-testlib/19.0/com/google/common/testing/EqualsTester.html">
   *     http://static.javadoc.io/com.google.guava/guava-testlib/19.0/com/google/common/testing/EqualsTester.html
   *     </a>
 *  @author Suresh Mahto
   */
  @Test
public void testEquals() {
var heroStatA = HeroStat.valueOf(3, 9, 2);
var heroStatB = HeroStat.valueOf(3, 9, 2);
new EqualsTester().addEqualityGroup(heroStatA, heroStatB).testEquals();
  }

  /**
   * The toString() for two equal values must be the same. For two non-equal values it must be
   * different.
 *  @author Suresh Mahto
   */
  @Test
public void testToString() {
var heroStatA = HeroStat.valueOf(3, 9, 2);
var heroStatB = HeroStat.valueOf(3, 9, 2);
var heroStatC = HeroStat.valueOf(3, 9, 8);

assertThat(heroStatA.toString(), is(heroStatB.toString()));
assertThat(heroStatA.toString(), is(not(heroStatC.toString())));
  }

}
