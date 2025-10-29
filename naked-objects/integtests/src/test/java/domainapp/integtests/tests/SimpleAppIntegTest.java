package domainapp.integtests.tests;

import org.junit.BeforeClass;

import org.apache.isis.core.integtestsupport.IntegrationTestAbstract;
import org.apache.isis.core.integtestsupport.scenarios.ScenarioExecutionForIntegration;

import domainapp.integtests.bootstrap.SimpleAppSystemInitializer;

/**
 * SimpleApp Integration Tests will implement this Abstract Class.
 */
public abstract class SimpleAppIntegTest extends IntegrationTestAbstract {

  @BeforeClass
  public static void initClass() {
    SimpleAppSystemInitializer.initIsft();

    // instantiating will install onto ThreadLocal
    new ScenarioExecutionForIntegration();
  }
}
