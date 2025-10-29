package com.iluwatar.acyclicvisitor;


import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

/**
 * Zoom test class
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class ZoomTest {
  
@Test
public void testAcceptForDos() {  
var zoom = new Zoom();
var mockVisitor = mock(ConfigureForDosVisitor.class);
    
zoom.accept(mockVisitor);
verify((ZoomVisitor)mockVisitor).visit(eq(zoom));
  }
  
@Test
public void testAcceptForUnix() {
var zoom = new Zoom();
var mockVisitor = mock(ConfigureForUnixVisitor.class);
    
zoom.accept(mockVisitor);
verify((ZoomVisitor)mockVisitor).visit(eq(zoom));
  }
}
