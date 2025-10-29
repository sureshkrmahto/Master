package domainapp.integtests.tests.modules.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import domainapp.dom.modules.simple.SimpleObject;
import domainapp.fixture.scenarios.RecreateSimpleObjects;
import domainapp.integtests.tests.SimpleAppIntegTest;
import javax.inject.Inject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.wrapper.DisabledException;
import org.apache.isis.applib.services.wrapper.InvalidException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Fixtures with Simple Objects
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class SimpleObjectIntegTest extends SimpleAppIntegTest {

  @Inject
  FixtureScripts fixtureScripts;
  @Inject
  DomainObjectContainer container;

  RecreateSimpleObjects fs;
  SimpleObject simpleObjectPojo;
  SimpleObject simpleObjectWrapped;
  
  private static final String NEW_NAME = "new name";

  @Before
  public void setUp() {
    // given
    fs = new RecreateSimpleObjects().setNumber(1);
    fixtureScripts.runFixtureScript(fs, null);

    simpleObjectPojo = fs.getSimpleObjects().get(0);

    assertNotNull(simpleObjectPojo);
    simpleObjectWrapped = wrap(simpleObjectPojo);
  }
  
  @Test
  public void testNameAccessible() {
    /* when */
    final var name = simpleObjectWrapped.getName();
    // then
    assertEquals(fs.names.get(0), name);
  }
  
  @Test
  public void testNameCannotBeUpdatedDirectly() {

    // expect
    expectedExceptions.expect(DisabledException.class);

    // when
    simpleObjectWrapped.setName(NEW_NAME);
  }
  
  @Test
  public void testUpdateName() {

    // when
    simpleObjectWrapped.updateName(NEW_NAME);

    // then
    assertEquals(NEW_NAME, simpleObjectWrapped.getName());
  }
  
  @Test
  public void testUpdateNameFailsValidation() {

    // expect
    expectedExceptions.expect(InvalidException.class);
    expectedExceptions.expectMessage("Exclamation mark is not allowed");

    // when
    simpleObjectWrapped.updateName(NEW_NAME + "!");
  }
  
  @Test
  public void testInterpolatesName() {

    // given
    final var name = simpleObjectWrapped.getName();

    // when
    final var title = container.titleOf(simpleObjectWrapped);

    // then
    assertEquals("Object: " + name, title);
  }
}
