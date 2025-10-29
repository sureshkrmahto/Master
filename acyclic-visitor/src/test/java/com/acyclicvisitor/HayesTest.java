package com.acyclicvisitor;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.Test;

/**
 * Hayes test class
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class HayesTest {

@Test
public void testAcceptForDos() {  
var hayes = new Hayes();
var mockVisitor = mock(ConfigureForDosVisitor.class);
    
hayes.accept(mockVisitor);
verify((HayesVisitor)mockVisitor).visit(eq(hayes));
  }
  
@Test
public void testAcceptForUnix() {    
var hayes = new Hayes();
var mockVisitor = mock(ConfigureForUnixVisitor.class);
    
hayes.accept(mockVisitor);
    
verifyZeroInteractions(mockVisitor);
  }
}
