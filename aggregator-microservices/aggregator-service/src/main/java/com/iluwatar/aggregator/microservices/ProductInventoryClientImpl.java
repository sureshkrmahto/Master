package com.iluwatar.aggregator.microservices;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * An adapter to communicate with inventory micro-service.
 */
@Component
public class ProductInventoryClientImpl implements ProductInventoryClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductInventoryClientImpl.class);

  @Override
  public Integer getProductInventories() {
    var response = "";

    var request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("http://localhost:51516/inventories"))
        .build();
    var client = HttpClient.newHttpClient();
    try {
      var httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
      response = httpResponse.body();
    } catch (IOException ioe) {
      LOGGER.error("IOException Occurred", ioe);
    } catch (InterruptedException ie) {
      LOGGER.error("InterruptedException Occurred", ie);
    }
    if ("".equalsIgnoreCase(response)) {
      return null;
    } else {
      return Integer.parseInt(response);
    }
  }
}
