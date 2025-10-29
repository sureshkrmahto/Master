package domainapp.fixture.modules.simple;

import domainapp.dom.modules.simple.SimpleObject;
import domainapp.dom.modules.simple.SimpleObjects;
import org.apache.isis.applib.fixturescripts.FixtureScript;

/**
 * Fixture to create a simple object.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class SimpleObjectCreate extends FixtureScript {

  // endregion


  // region > simpleObject (output)
  private SimpleObject simpleObject;

  @javax.inject.Inject
  private SimpleObjects simpleObjects;

  // region > name (input)
  private String name;

  /**
   * Name of the object (required).
   */
  public String getName() {
    return name;
  }

  public SimpleObjectCreate setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The created simple object (output).
   */
  public SimpleObject getSimpleObject() {
    return simpleObject;
  }

  // endregion

  @Override
  protected void execute(final ExecutionContext ec) {
    var paramName = checkParam("name", ec, String.class);

    this.simpleObject = wrap(simpleObjects).create(paramName);

    // also make available to UI
    ec.addResult(this, simpleObject);
  }

}
