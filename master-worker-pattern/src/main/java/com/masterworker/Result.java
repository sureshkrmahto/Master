package com.masterworker;

/**
 * The abstract Result class, which contains 1 public field containing result data.
 *
 * @param <T> T will be type of data.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Result<T> {

public final T data;

public Result(T data) {
this.data = data;
  }
}
