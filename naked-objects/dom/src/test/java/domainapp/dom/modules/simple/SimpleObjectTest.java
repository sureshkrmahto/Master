package domainapp.dom.modules.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for SimpleObject
 */
public class SimpleObjectTest {

  SimpleObject simpleObject;

  @Before
  public void setUp() {
    simpleObject = new SimpleObject();
  }
  
  @Test
  public void testName() {
    // given
    String name = "Foobar";
    assertNull(simpleObject.getName());

    // when
    simpleObject.setName(name);

    // then
    assertEquals(name, simpleObject.getName());
  }

}
