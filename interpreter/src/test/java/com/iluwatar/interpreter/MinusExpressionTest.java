package com.iluwatar.interpreter;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class MinusExpressionTest extends ExpressionTest<MinusExpression> {

  /**
   * Create a new set of test entries with the expected result
   *
   * @return The list of parameters used during this test
 *  @author Suresh Mahto
   */
  @Override
public Stream<Arguments> expressionProvider() {
return prepareParameters((f, s) -> f - s);
  }

  /**
   * Create a new test instance using the given test parameters and expected result
 *  @author Suresh Mahto
   */
public MinusExpressionTest() {
super("-", MinusExpression::new);
  }

}