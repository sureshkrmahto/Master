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
 * An adapter to communicate with information micro-service.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
@Component
public class ProductInformationClientImpl implements ProductInformationClient {

private static final Logger LOGGER = LoggerFactory.getLogger(ProductInformationClientImpl.class);

@Override
public String getProductTitle() {
var request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("http://localhost:51515/information"))
        .build();
var client = HttpClient.newHttpClient();
try {
var httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
return httpResponse.body();
    } catch (IOException ioe) {
LOGGER.error("IOException Occurred", ioe);
    } catch (InterruptedException ie) {
LOGGER.error("InterruptedException Occurred", ie);
    }
return null;
  }
}
