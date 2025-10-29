package com.aggregator.microservices;

import static java.util.Objects.requireNonNullElse;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The aggregator aggregates calls on various micro-services, collects data and further publishes
 * them under a REST endpoint.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
@RestController
public class Aggregator {


@Resource
private ProductInformationClient informationClient;

@Resource
private ProductInventoryClient inventoryClient;


  /**
   * Retrieves product data.
   *
   * @return a Product.
 *  @author Suresh Mahto
   */
  @RequestMapping(path = "/product", method = RequestMethod.GET)
public Product getProduct() {

var product = new Product();
var productTitle = informationClient.getProductTitle();
var productInventory = inventoryClient.getProductInventories();

    //Fallback to error message
product.setTitle(requireNonNullElse(productTitle, "Error: Fetching Product Title Failed"));

    //Fallback to default error inventory
product.setProductInventories(requireNonNullElse(productInventory, -1));

return product;
  }

}
