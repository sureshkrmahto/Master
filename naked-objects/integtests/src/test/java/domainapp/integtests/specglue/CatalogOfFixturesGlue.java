package domainapp.integtests.specglue;

import cucumber.api.java.Before;
import domainapp.fixture.scenarios.RecreateSimpleObjects;
import org.apache.isis.core.specsupport.specs.CukeGlueAbstract;

/**
 * Test Execution to append a fixture of SimpleObjects
 */
public class CatalogOfFixturesGlue extends CukeGlueAbstract {

  @Before(value = {"@integration", "@SimpleObjectsFixture"}, order = 20000)
  public void integrationFixtures() {
    scenarioExecution().install(new RecreateSimpleObjects());
  }
}
