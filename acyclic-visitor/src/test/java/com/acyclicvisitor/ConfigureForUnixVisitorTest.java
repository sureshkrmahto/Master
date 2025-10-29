package com.acyclicvisitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static uk.org.lidalia.slf4jext.Level.INFO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

/**
 * ConfigureForUnixVisitor test class
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class ConfigureForUnixVisitorTest {
  
private static final TestLogger LOGGER = TestLoggerFactory.getTestLogger(ConfigureForUnixVisitor.class);
  
@AfterEach
public void clearLoggers() {
TestLoggerFactory.clear();
  }
  
@Test
public void testVisitForZoom() {
var conUnix = new ConfigureForUnixVisitor();
var zoom = new Zoom();
    
conUnix.visit(zoom);
    
assertThat(LOGGER.getLoggingEvents())
        .extracting("level", "message")
        .contains(tuple(INFO, zoom + " used with Unix configurator."));
  }
}
