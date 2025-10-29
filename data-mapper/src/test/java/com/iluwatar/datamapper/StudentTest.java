package com.iluwatar.datamapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests {@link Student}.
 */
public final class StudentTest {

  /**
   * This API tests the equality behaviour of Student object Object Equality should work as per
   * logic defined in equals method
   *
   * @throws Exception if any execution error during test
   */
  @Test
  public void testEquality() throws Exception {

    /* Create some students */
    final var firstStudent = new Student(1, "Adam", 'A');
    final var secondStudent = new Student(2, "Donald", 'B');
    final var secondSameStudent = new Student(2, "Donald", 'B');

    /* Check equals functionality: should return 'true' */
    assertEquals(firstStudent, firstStudent);

    /* Check equals functionality: should return 'false' */
    assertNotEquals(firstStudent, secondStudent);

    /* Check equals functionality: should return 'true' */
    assertEquals(secondStudent, secondSameStudent);
  }
}
