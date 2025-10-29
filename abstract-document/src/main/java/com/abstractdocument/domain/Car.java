package com.abstractdocument.domain;

import com.abstractdocument.AbstractDocument;
import java.util.Map;

/**
 * Car entity.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

public Car(Map<String, Object> properties) {
super(properties);
  }

}
