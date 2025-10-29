package domainapp.fixture.modules.simple;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

/**
 * TearDown/Cleanup for SimpleObjects.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class SimpleObjectsTearDown extends FixtureScript {

@javax.inject.Inject
private IsisJdoSupport isisJdoSupport;

@Override
protected void execute(ExecutionContext executionContext) {
isisJdoSupport.executeUpdate("delete from \"simple\".\"SimpleObject\"");
  }

}
