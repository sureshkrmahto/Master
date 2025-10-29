package domainapp.fixture.scenarios;

import com.google.common.collect.Lists;
import domainapp.dom.modules.simple.SimpleObject;
import domainapp.fixture.modules.simple.SimpleObjectCreate;
import domainapp.fixture.modules.simple.SimpleObjectsTearDown;
import java.util.List;
import org.apache.isis.applib.fixturescripts.FixtureScript;


/**
 * Create a bunch of simple Objects.
 

 * @author Suresh Mahto


 */
/**
 * @author Suresh Mahto
 */
public class RecreateSimpleObjects extends FixtureScript {

  public final List<String> names = List.of(
      "Foo",
      "Bar",
      "Baz",
      "Frodo",
      "Froyo",
      "Fizz",
      "Bip",
      "Bop",
      "Bang",
      "Boo"
  );

  // region > number (optional input)
  private Integer number;

  // endregion

  // region > simpleObjects (output)
  private final List<SimpleObject> simpleObjects = Lists.newArrayList();

  public RecreateSimpleObjects() {
    withDiscoverability(Discoverability.DISCOVERABLE);
  }

  /**
   * The number of objects to create, up to 10; optional, defaults to 3.
   */
  public Integer getNumber() {
    return number;
  }

  public RecreateSimpleObjects setNumber(final Integer number) {
    this.number = number;
    return this;
  }

  /**
   * The simpleobjects created by this fixture (output).
   */
  public List<SimpleObject> getSimpleObjects() {
    return simpleObjects;
  }

  // endregion

  @Override
  protected void execute(final ExecutionContext ec) {

    // defaults
    final var paramNumber = defaultParam("number", ec, 3);

    // validate
    if (paramNumber < 0 || paramNumber > names.size()) {
      throw new IllegalArgumentException(String.format("number must be in range [0,%d)",
          names.size()));
    }

    //
    // execute
    //
    ec.executeChild(this, new SimpleObjectsTearDown());

    for (var i = 0; i < paramNumber; i++) {
      final var fs = new SimpleObjectCreate().setName(names.get(i));
      ec.executeChild(this, fs.getName(), fs);
      simpleObjects.add(fs.getSimpleObject());
    }
  }
}
