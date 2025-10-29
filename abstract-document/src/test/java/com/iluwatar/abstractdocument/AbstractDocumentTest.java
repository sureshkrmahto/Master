package com.iluwatar.abstractdocument;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * AbstractDocument test class
 */
public class AbstractDocumentTest {

  private static final String KEY = "key";
  private static final String VALUE = "value";

  private static class DocumentImplementation extends AbstractDocument {

    DocumentImplementation(Map<String, Object> properties) {
      super(properties);
    }
  }

  private final DocumentImplementation document = new DocumentImplementation(new HashMap<>());

  @Test
  public void shouldPutAndGetValue() {
    document.put(KEY, VALUE);
    assertEquals(VALUE, document.get(KEY));
  }

  @Test
  public void shouldRetrieveChildren() {
    var children = List.of(Map.of(), Map.of());

    document.put(KEY, children);

    var childrenStream = document.children(KEY, DocumentImplementation::new);
    assertNotNull(children);
    assertEquals(2, childrenStream.count());
  }

  @Test
  public void shouldRetrieveEmptyStreamForNonExistingChildren() {
    var children = document.children(KEY, DocumentImplementation::new);
    assertNotNull(children);
    assertEquals(0, children.count());
  }

  @Test
  public void shouldIncludePropsInToString() {
    var props = Map.of(KEY, (Object) VALUE);
    var document = new DocumentImplementation(props);
    assertTrue(document.toString().contains(KEY));
    assertTrue(document.toString().contains(VALUE));
  }

}
