package com.iluwatar.abstractdocument.domain;

import com.iluwatar.abstractdocument.AbstractDocument;
import java.util.Map;

/**
 * Car entity.
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

  public Car(Map<String, Object> properties) {
    super(properties);
  }

}
