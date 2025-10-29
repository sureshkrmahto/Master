package com.iluwatar.abstractdocument.domain;

import com.iluwatar.abstractdocument.Document;
import com.iluwatar.abstractdocument.domain.enums.Property;
import java.util.Optional;

/**
 * HasType trait for static access to 'type' property.
 */
public interface HasType extends Document {

  default Optional<String> getType() {
    return Optional.ofNullable((String) get(Property.TYPE.toString()));
  }

}
