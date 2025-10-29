package com.iluwatar.datatransfer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Data Transfer Object pattern is a design pattern in which an data transfer object is used to
 * serve related information together to avoid multiple call for each piece of information.
 *
 * <p>In this example, ({@link App}) as as customer details consumer i.e. client to
 * request for customer details to server.
 *
 * <p>CustomerResource ({@link CustomerResource}) act as server to serve customer information. And
 * The CustomerDto ({@link CustomerDto} is data transfer object to share customer information.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Method as act client and request to server for details.
   *
   * @param args program argument.
   */
  public static void main(String[] args) {
    var customerOne = new CustomerDto("1", "Kelly", "Brown");
    var customerTwo = new CustomerDto("2", "Alfonso", "Bass");
    var customers = new ArrayList<>(List.of(customerOne, customerTwo));

    var customerResource = new CustomerResource(customers);

    LOGGER.info("All customers:-");
    var allCustomers = customerResource.getAllCustomers();
    printCustomerDetails(allCustomers);

    LOGGER.info("----------------------------------------------------------");

    LOGGER.info("Deleting customer with id {1}");
    customerResource.delete(customerOne.getId());
    allCustomers = customerResource.getAllCustomers();
    printCustomerDetails(allCustomers);

    LOGGER.info("----------------------------------------------------------");

    LOGGER.info("Adding customer three}");
    var customerThree = new CustomerDto("3", "Lynda", "Blair");
    customerResource.save(customerThree);
    allCustomers = customerResource.getAllCustomers();
    printCustomerDetails(allCustomers);
  }

  private static void printCustomerDetails(List<CustomerDto> allCustomers) {
    allCustomers.forEach(customer -> LOGGER.info(customer.getFirstName()));
  }
}
