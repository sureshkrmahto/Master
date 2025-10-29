package com.iluwatar.aggregator.microservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Test Aggregation of domain objects
 */
public class AggregatorTest {

  @InjectMocks
  private Aggregator aggregator;

  @Mock
  private ProductInformationClient informationClient;

  @Mock
  private ProductInventoryClient inventoryClient;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Tests getting the data for a desktop client
   */
  @Test
  public void testGetProduct() {
    var title = "The Product Title.";
    var inventories = 5;

    when(informationClient.getProductTitle()).thenReturn(title);
    when(inventoryClient.getProductInventories()).thenReturn(inventories);

    var testProduct = aggregator.getProduct();

    assertEquals(title, testProduct.getTitle());
    assertEquals(inventories, testProduct.getProductInventories());
  }

}
