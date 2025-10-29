package com.iluwatar.abstractdocument.domain;

import com.iluwatar.abstractdocument.Document;
import com.iluwatar.abstractdocument.domain.enums.Property;
import java.util.Optional;

/**
 * HasPrice trait for static access to 'price' property.
 *  @author Suresh Mahto
 */
public interface HasPrice extends Document {

default Optional<Number> getPrice() {
return Optional.ofNullable((Number) get(Property.PRICE.toString()));
  }

}
