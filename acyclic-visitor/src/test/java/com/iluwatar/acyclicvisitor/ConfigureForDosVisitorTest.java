package com.iluwatar.acyclicvisitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static uk.org.lidalia.slf4jext.Level.INFO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

/**
 * ConfigureForDosVisitor test class
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ConfigureForDosVisitorTest {

  private final TestLogger logger = TestLoggerFactory.getTestLogger(ConfigureForDosVisitor.class);
  
  @Test
  public void testVisitForZoom() {    
    var conDos = new ConfigureForDosVisitor();
    var zoom = new Zoom();
    
    conDos.visit(zoom);
    
    assertThat(logger.getLoggingEvents())
        .extracting("level", "message")
        .contains(tuple(INFO, zoom + " used with Dos configurator."));
  }
  
  @Test
  public void testVisitForHayes() {
    var conDos = new ConfigureForDosVisitor();
    var hayes = new Hayes();
    
    conDos.visit(hayes);
    
    assertThat(logger.getLoggingEvents())
        .extracting("level", "message")
        .contains(tuple(INFO, hayes + " used with Dos configurator."));
  }
  
  @AfterEach
  public void clearLoggers() {
    TestLoggerFactory.clear();
  }
}
