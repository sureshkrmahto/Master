package com.nullobject;

/**
 * Null Object pattern replaces null values with neutral objects. Many times this simplifies
 * algorithms since no extra null checks are needed.
 *
 * <p>In this example we build a binary tree where the nodes are either normal or Null Objects. No
 * null values are used in the tree making the traversal easy.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {
  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var root = new NodeImpl("1",
new NodeImpl("11",
new NodeImpl("111", NullNode.getInstance(), NullNode.getInstance()),
NullNode.getInstance()
        ),
new NodeImpl("12",
NullNode.getInstance(),
new NodeImpl("122", NullNode.getInstance(), NullNode.getInstance())
        )
    );

root.walk();
  }
}
