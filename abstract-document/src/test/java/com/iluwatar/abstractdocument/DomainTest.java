package com.iluwatar.abstractdocument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.iluwatar.abstractdocument.domain.Car;
import com.iluwatar.abstractdocument.domain.Part;
import com.iluwatar.abstractdocument.domain.enums.Property;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Test for Part and Car
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class DomainTest {

private static final String TEST_PART_TYPE = "test-part-type";
private static final String TEST_PART_MODEL = "test-part-model";
private static final long TEST_PART_PRICE = 0L;

private static final String TEST_CAR_MODEL = "test-car-model";
private static final long TEST_CAR_PRICE = 1L;

@Test
public void shouldConstructPart() {
var partProperties = Map.of(
Property.TYPE.toString(), TEST_PART_TYPE,
Property.MODEL.toString(), TEST_PART_MODEL,
Property.PRICE.toString(), (Object) TEST_PART_PRICE
    );
var part = new Part(partProperties);
assertEquals(TEST_PART_TYPE, part.getType().orElseThrow());
assertEquals(TEST_PART_MODEL, part.getModel().orElseThrow());
assertEquals(TEST_PART_PRICE, part.getPrice().orElseThrow());
  }

@Test
public void shouldConstructCar() {
var carProperties = Map.of(
Property.MODEL.toString(), TEST_CAR_MODEL,
Property.PRICE.toString(), TEST_CAR_PRICE,
Property.PARTS.toString(), List.of(Map.of(), Map.of())
    );
var car = new Car(carProperties);
assertEquals(TEST_CAR_MODEL, car.getModel().orElseThrow());
assertEquals(TEST_CAR_PRICE, car.getPrice().orElseThrow());
assertEquals(2, car.getParts().count());
  }

}
