package com.iluwatar.abstractdocument.domain;

import com.iluwatar.abstractdocument.Document;
import com.iluwatar.abstractdocument.domain.enums.Property;
import java.util.Optional;

/**
 * HasModel trait for static access to 'model' property.
 */
public interface HasModel extends Document {

  default Optional<String> getModel() {
    return Optional.ofNullable((String) get(Property.MODEL.toString()));
  }

}
