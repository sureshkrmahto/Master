package com.iluwatar.pipeline;

/**
 * Forms a contract to all stage handlers to accept a certain type of input and return a processed
 * output.
 *
 * @param <I> the input type of the handler
 * @param <O> the processed output type of the handler
 */
interface Handler<I, O> {
  O process(I input);
}