package com.iluwatar.pipeline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link Pipeline}
 */
public class PipelineTest {

  @Test
  public void testAddHandlersToPipeline() {
    var filters = new Pipeline<>(new RemoveAlphabetsHandler())
        .addHandler(new RemoveDigitsHandler())
        .addHandler(new ConvertToCharArrayHandler());

    assertArrayEquals(
        new char[]{'#', '!', '(', '&', '%', '#', '!'},
        filters.execute("#H!E(L&L0O%THE3R#34E!")
    );
  }
}
