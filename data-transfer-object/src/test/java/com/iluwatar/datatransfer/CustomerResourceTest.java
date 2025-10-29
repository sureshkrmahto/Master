package com.iluwatar.datatransfer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * tests {@link CustomerResource}.
 */
public class CustomerResourceTest {
  @Test
  public void shouldGetAllCustomers() {
    var customers = List.of(new CustomerDto("1", "Melody", "Yates"));
    var customerResource = new CustomerResource(customers);
    var allCustomers = customerResource.getAllCustomers();

    assertEquals(1, allCustomers.size());
    assertEquals("1", allCustomers.get(0).getId());
    assertEquals("Melody", allCustomers.get(0).getFirstName());
    assertEquals("Yates", allCustomers.get(0).getLastName());
  }

  @Test
  public void shouldSaveCustomer() {
    var customer = new CustomerDto("1", "Rita", "Reynolds");
    var customerResource = new CustomerResource(new ArrayList<>());

    customerResource.save(customer);

    var allCustomers = customerResource.getAllCustomers();
    assertEquals("1", allCustomers.get(0).getId());
    assertEquals("Rita", allCustomers.get(0).getFirstName());
    assertEquals("Reynolds", allCustomers.get(0).getLastName());
  }

  @Test
  public void shouldDeleteCustomer() {
    var customer = new CustomerDto("1", "Terry", "Nguyen");
    var customers = new ArrayList<>(List.of(customer));
    var customerResource = new CustomerResource(customers);

    customerResource.delete(customer.getId());

    var allCustomers = customerResource.getAllCustomers();
    assertTrue(allCustomers.isEmpty());
  }

}