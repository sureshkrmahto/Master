package com.eip.aggregator.routes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.junit.jupiter.api.Test;

/**
 * Tests MessageAggregationStrategy
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class MessageAggregationStrategyTest {

@Test
public void testAggregate() {
var mas = new MessageAggregationStrategy();
var oldExchange = new DefaultExchange((CamelContext) null);
oldExchange.getIn().setBody("TEST1");

var newExchange = new DefaultExchange((CamelContext) null);
newExchange.getIn().setBody("TEST2");

var output = mas.aggregate(oldExchange, newExchange);
var outputBody = (String) output.getIn().getBody();
assertEquals("TEST1;TEST2", outputBody);
  }

@Test
public void testAggregateOldNull() {
var mas = new MessageAggregationStrategy();

var newExchange = new DefaultExchange((CamelContext) null);
newExchange.getIn().setBody("TEST2");

var output = mas.aggregate(null, newExchange);
var outputBody = (String) output.getIn().getBody();

assertEquals(newExchange, output);
assertEquals("TEST2", outputBody);
  }
}
