package domainapp.integtests.bootstrap;

import org.apache.isis.core.commons.config.IsisConfiguration;
import org.apache.isis.core.integtestsupport.IsisSystemForTest;
import org.apache.isis.objectstore.jdo.datanucleus.DataNucleusPersistenceMechanismInstaller;
import org.apache.isis.objectstore.jdo.datanucleus.IsisConfigurationForJdoIntegTests;

/**
 * Initializer for the Simple App
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public final class SimpleAppSystemInitializer {

  private SimpleAppSystemInitializer() {
  }

  /**
   * Init test system
   */
  public static void initIsft() {
    var isft = IsisSystemForTest.getElseNull();
    if (isft == null) {
      isft = new SimpleAppSystemBuilder().build().setUpSystem();
      IsisSystemForTest.set(isft);
    }
  }


/**

 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
  private static class SimpleAppSystemBuilder extends IsisSystemForTest.Builder {

    public SimpleAppSystemBuilder() {
      with(testConfiguration());
      with(new DataNucleusPersistenceMechanismInstaller());

      // services annotated with @DomainService
      withServicesIn("domainapp");
    }

    private static IsisConfiguration testConfiguration() {
      final var testConfiguration = new IsisConfigurationForJdoIntegTests();

      testConfiguration.addRegisterEntitiesPackagePrefix("domainapp.dom.modules");
      return testConfiguration;
    }
  }
}
