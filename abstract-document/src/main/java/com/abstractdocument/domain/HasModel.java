package com.abstractdocument.domain;

import com.abstractdocument.Document;
import com.abstractdocument.domain.enums.Property;
import java.util.Optional;

/**
 * HasModel trait for static access to 'model' property.
 *  @author Suresh Mahto
 */
public interface HasModel extends Document {

default Optional<String> getModel() {
return Optional.ofNullable((String) get(Property.MODEL.toString()));
  }

}
