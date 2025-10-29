package com.iluwatar.abstractdocument.domain;

import com.iluwatar.abstractdocument.AbstractDocument;
import java.util.Map;

/**
 * Part entity.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

  public Part(Map<String, Object> properties) {
    super(properties);
  }

}
