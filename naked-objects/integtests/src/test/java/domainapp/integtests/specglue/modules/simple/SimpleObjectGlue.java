package domainapp.integtests.specglue.modules.simple;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import domainapp.dom.modules.simple.SimpleObjects;
import java.util.UUID;
import org.apache.isis.core.specsupport.specs.CukeGlueAbstract;

/**
 * Test Simple Object Operations
 */
public class SimpleObjectGlue extends CukeGlueAbstract {

  @Given("^there are.* (\\d+) simple objects$")
  public void thereAreNumSimpleObjects(int n) {
    try {
      final var findAll = service(SimpleObjects.class).listAll();
      assertThat(findAll.size(), is(n));
      putVar("list", "all", findAll);

    } finally {
      assertMocksSatisfied();
    }
  }

  @When("^I create a new simple object$")
  public void createNewSimpleObject() {
    service(SimpleObjects.class).create(UUID.randomUUID().toString());
  }

}
