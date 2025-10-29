package com.iluwatar.pipeline;

/**
 * Main Pipeline class that initially sets the current handler. Processed output of the initial
 * handler is then passed as the input to the next stage handlers.
 *
 * @param <I> the type of the input for the first stage handler
 * @param <O> the final stage handler's output type
 */
class Pipeline<I, O> {

  private final Handler<I, O> currentHandler;

  Pipeline(Handler<I, O> currentHandler) {
    this.currentHandler = currentHandler;
  }

  <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
    return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
  }

  O execute(I input) {
    return currentHandler.process(input);
  }
}