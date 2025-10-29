package com.iluwatar.nullobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
class NullNodeTest {

  /**
   * Verify if {@link NullNode#getInstance()} actually returns the same object instance
*/
  @Test
void testGetInstance() {
final var instance = NullNode.getInstance();
assertNotNull(instance);
assertSame(instance, NullNode.getInstance());
  }

@Test
void testFields() {
final var node = NullNode.getInstance();
assertEquals(0, node.getTreeSize());
assertNull(node.getName());
assertNull(node.getLeft());
assertNull(node.getRight());
  }

  /**
   * Removed unnecessary test method for {@link NullNode#walk()} as the method doesn't have an implementation.
   */

}
