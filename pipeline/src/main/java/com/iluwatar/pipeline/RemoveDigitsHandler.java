package com.iluwatar.pipeline;

import java.util.function.IntPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Stage handler that returns a new instance of String without the digit characters of the input
 * string.
 */
class RemoveDigitsHandler implements Handler<String, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(RemoveDigitsHandler.class);

  @Override
  public String process(String input) {
    var inputWithoutDigits = new StringBuilder();
    var isDigit = (IntPredicate) Character::isDigit;
    input.chars()
        .filter(isDigit.negate())
        .mapToObj(x -> (char) x)
        .forEachOrdered(inputWithoutDigits::append);

    var inputWithoutDigitsStr = inputWithoutDigits.toString();
    LOGGER.info(
        String.format(
            "Current handler: %s, input is %s of type %s, output is %s, of type %s",
            RemoveDigitsHandler.class, input, String.class, inputWithoutDigitsStr, String.class
        )
    );

    return inputWithoutDigitsStr;
  }
}