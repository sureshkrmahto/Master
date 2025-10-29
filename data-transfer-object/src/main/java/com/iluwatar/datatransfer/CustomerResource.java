package com.iluwatar.datatransfer;

import java.util.List;

/**
 * The resource class which serves customer information. This class act as server in the demo. Which
 * has all customer details.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class CustomerResource {
private final List<CustomerDto> customers;

  /**
   * Initialise resource with existing customers.
   *
   * @param customers initialize resource with existing customers. Act as database.
 *  @author Suresh Mahto
   */
public CustomerResource(List<CustomerDto> customers) {
this.customers = customers;
  }

  /**
   * Get all customers.
   *
   * @return : all customers in list.
 *  @author Suresh Mahto
   */
public List<CustomerDto> getAllCustomers() {
return customers;
  }

  /**
   * Save new customer.
   *
   * @param customer save new customer to list.
 *  @author Suresh Mahto
   */
public void save(CustomerDto customer) {
customers.add(customer);
  }

  /**
   * Delete customer with given id.
   *
   * @param customerId delete customer with id {@code customerId}
 *  @author Suresh Mahto
   */
public void delete(String customerId) {
customers.removeIf(customer -> customer.getId().equals(customerId));
  }
}