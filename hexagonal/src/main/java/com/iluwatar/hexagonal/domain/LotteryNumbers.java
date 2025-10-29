package com.iluwatar.hexagonal.domain;

import com.google.common.base.Joiner;
import java.util.Collections;
import java.util.HashSet;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Set;

/**
 * Value object representing lottery numbers. This lottery uses sets of 4 numbers. The numbers must
 * be unique and between 1 and 20.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LotteryNumbers {

private final Set<Integer> numbers;

public static final int MIN_NUMBER = 1;
public static final int MAX_NUMBER = 20;
public static final int NUM_NUMBERS = 4;

  /**
   * Constructor. Creates random lottery numbers.
 *  @author Suresh Mahto
   */
private LotteryNumbers() {
numbers = new HashSet<>();
generateRandomNumbers();
  }

  /**
   * Constructor. Uses given numbers.
 *  @author Suresh Mahto
   */
private LotteryNumbers(Set<Integer> givenNumbers) {
numbers = new HashSet<>();
numbers.addAll(givenNumbers);
  }

  /**
   * Creates a random lottery number.
   *
   * @return random LotteryNumbers
 *  @author Suresh Mahto
   */
public static LotteryNumbers createRandom() {
return new LotteryNumbers();
  }

  /**
   * Creates lottery number from given set of numbers.
   *
   * @return given LotteryNumbers
 *  @author Suresh Mahto
   */
public static LotteryNumbers create(Set<Integer> givenNumbers) {
return new LotteryNumbers(givenNumbers);
  }

  /**
   * Get numbers.
   *
   * @return lottery numbers
 *  @author Suresh Mahto
   */
public Set<Integer> getNumbers() {
return Collections.unmodifiableSet(numbers);
  }

  /**
   * Get numbers as string.
   *
   * @return numbers as comma separated string
 *  @author Suresh Mahto
   */
public String getNumbersAsString() {
return Joiner.on(',').join(numbers);
  }

  /**
   * Generates 4 unique random numbers between 1-20 into numbers set.
 *  @author Suresh Mahto
   */
private void generateRandomNumbers() {
numbers.clear();
var generator = new RandomNumberGenerator(MIN_NUMBER, MAX_NUMBER);
while (numbers.size() < NUM_NUMBERS) {
var num = generator.nextInt();
numbers.add(num);
    }
  }

@Override
public String toString() {
return "LotteryNumbers{" + "numbers=" + numbers + '}';
  }

  /**
   * Helper class for generating random numbers.
   
   * @author Suresh Mahto

 *  @author Suresh Mahto
   */
private static class RandomNumberGenerator {

private final PrimitiveIterator.OfInt randomIterator;

    /**
     * Initialize a new random number generator that generates random numbers in the range [min,
     * max].
     *
     * @param min the min value (inclusive)
     * @param max the max value (inclusive)
 *  @author Suresh Mahto
     */
public RandomNumberGenerator(int min, int max) {
randomIterator = new Random().ints(min, max + 1).iterator();
    }

    /**
     * Gets next random integer in [min, max] range.
     *
     * @return a random number in the range (min, max)
 *  @author Suresh Mahto
     */
public int nextInt() {
return randomIterator.nextInt();
    }
  }

@Override
public int hashCode() {
final var prime = 31;
var result = 1;
result = prime * result + ((numbers == null) ? 0 : numbers.hashCode());
return result;
  }

@Override
public boolean equals(Object obj) {
if (this == obj) {
return true;
    }
if (obj == null) {
return false;
    }
if (getClass() != obj.getClass()) {
return false;
    }
var other = (LotteryNumbers) obj;
if (numbers == null) {
return other.numbers == null;
    } else {
return numbers.equals(other.numbers);
    }
  }
}
