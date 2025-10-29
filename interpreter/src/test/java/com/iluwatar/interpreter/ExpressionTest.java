package com.iluwatar.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * <p>
 * Test Case for Expressions
 *
 * @param <E> Type of Expression
 * @author Suresh Mahto
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class ExpressionTest<E extends Expression> {

  /**
   * Generate inputs ranging from -10 to 10 for both input params and calculate the expected result
   *
   * @param resultCalc The function used to calculate the expected result
   * @return A stream with test entries
   */
  static Stream<Arguments> prepareParameters(final IntBinaryOperator resultCalc) {
    final var testData = new ArrayList<Arguments>();
    for (var i = -10; i < 10; i++) {
      for (var j = -10; j < 10; j++) {
        testData.add(Arguments.of(
            new NumberExpression(i),
            new NumberExpression(j),
            resultCalc.applyAsInt(i, j)
        ));
      }
    }
    return testData.stream();
  }

  /**
   * The expected {@link E#toString()} response
   */
  private final String expectedToString;

  /**
   * Factory, used to create a new test object instance with the correct first and second parameter
   */
  private final BiFunction<NumberExpression, NumberExpression, E> factory;

  /**
   * Create a new test instance with the given parameters and expected results
   *
   * @param expectedToString The expected {@link E#toString()} response
   * @param factory          Factory, used to create a new test object instance
   */
  ExpressionTest(final String expectedToString,
                 final BiFunction<NumberExpression, NumberExpression, E> factory
  ) {
    this.expectedToString = expectedToString;
    this.factory = factory;
  }

  /**
   * Create a new set of test entries with the expected result
   *
   * @return The list of parameters used during this test
   */
  public abstract Stream<Arguments> expressionProvider();

  /**
   * Verify if the expression calculates the correct result when calling {@link E#interpret()}
   */
  @ParameterizedTest
  @MethodSource("expressionProvider")
  public void testInterpret(NumberExpression first, NumberExpression second, int result) {
    final var expression = factory.apply(first, second);
    assertNotNull(expression);
    assertEquals(result, expression.interpret());
  }

  /**
   * Verify if the expression has the expected {@link E#toString()} value
   */
  @ParameterizedTest
  @MethodSource("expressionProvider")
  public void testToString(NumberExpression first, NumberExpression second) {
    final var expression = factory.apply(first, second);
    assertNotNull(expression);
    assertEquals(expectedToString, expression.toString());
  }
}
