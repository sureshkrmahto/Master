package com.iluwatar.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**

 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
class CarsFactoryTest {

	@Test
	void shouldReturnFerrariInstance() {
		final var ferrari = CarsFactory.getCar(CarType.FERRARI);
		assertTrue(ferrari instanceof Ferrari);
	}

}
