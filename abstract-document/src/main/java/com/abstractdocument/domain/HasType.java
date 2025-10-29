package com.abstractdocument.domain;

import com.abstractdocument.Document;
import com.abstractdocument.domain.enums.Property;
import java.util.Optional;

/**
 * HasType trait for static access to 'type' property.
 *  @author Suresh Mahto
 */
public interface HasType extends Document {

default Optional<String> getType() {
return Optional.ofNullable((String) get(Property.TYPE.toString()));
  }

}
