package domainapp.dom.modules.simple;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.core.unittestsupport.jmocking.JUnitRuleMockery2;
import org.apache.isis.core.unittestsupport.jmocking.JUnitRuleMockery2.Mode;
import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.auto.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test for SimpleObjects
 */
public class SimpleObjectsTest {

  @Rule
  public JUnitRuleMockery2 context = JUnitRuleMockery2.createFor(Mode.INTERFACES_AND_CLASSES);

  @Mock
  DomainObjectContainer mockContainer;

  SimpleObjects simpleObjects;

  @Before
  public void setUp() {
    simpleObjects = new SimpleObjects();
    simpleObjects.container = mockContainer;
  }
  
  @Test
  public void testCreate() {

    // given
    final SimpleObject simpleObject = new SimpleObject();

    final Sequence seq = context.sequence("create");
    context.checking(new Expectations() {
      {
        oneOf(mockContainer).newTransientInstance(SimpleObject.class);
        inSequence(seq);
        will(returnValue(simpleObject));

        oneOf(mockContainer).persistIfNotAlready(simpleObject);
        inSequence(seq);
      }
    });

    // when
    String objectName = "Foobar";
    final SimpleObject obj = simpleObjects.create(objectName);

    // then
    assertEquals(simpleObject, obj);
    assertEquals(objectName, obj.getName());
  }
  
  @Test
  public void testListAll() {

    // given
    final List<SimpleObject> all = Lists.newArrayList();

    context.checking(new Expectations() {
      {
        oneOf(mockContainer).allInstances(SimpleObject.class);
        will(returnValue(all));
      }
    });

    // when
    final List<SimpleObject> list = simpleObjects.listAll();

    // then
    assertEquals(all, list);
  }

}
