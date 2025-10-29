package com.nullobject;

/**
 * Null Object implementation for binary tree node.
 *
 * <p>Implemented as Singleton, since all the NullNodes are the same.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public final class NullNode implements Node {

private static final NullNode instance = new NullNode();

private NullNode() {
  }

public static NullNode getInstance() {
return instance;
  }

@Override
public int getTreeSize() {
return 0;
  }

@Override
public Node getLeft() {
return null;
  }

@Override
public Node getRight() {
return null;
  }

@Override
public String getName() {
return null;
  }

@Override
public void walk() {
    // Do nothing
  }
}
