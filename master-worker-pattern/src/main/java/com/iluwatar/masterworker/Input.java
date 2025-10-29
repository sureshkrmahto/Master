package com.iluwatar.masterworker;

import java.util.List;

/**
 * The abstract Input class, having 1 public field which contains input data, and abstract method
 * divideData.
 *
 * @param <T> T will be type of data.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Input<T> {

public final T data;

public Input(T data) {
this.data = data;
  }

public abstract List<Input<T>> divideData(int num);
}
