package domainapp.dom.app.homepage;

import domainapp.dom.modules.simple.SimpleObject;
import domainapp.dom.modules.simple.SimpleObjects;
import java.util.List;
import org.apache.isis.applib.annotation.ViewModel;

/**
 * Model linked to the HomePage The underlying layout is specified by json.
 *
 * @see HomePageService - Service Linked to the HomePage
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
@ViewModel
public class HomePageViewModel {

  // endregion

  // region > injected services

@javax.inject.Inject
SimpleObjects simpleObjects;

  // endregion

  // region > title
public String title() {
return getObjects().size() + " objects";
  }

  // endregion

  // region > object (collection)
@org.apache.isis.applib.annotation.HomePage
public List<SimpleObject> getObjects() {
return simpleObjects.listAll();
  }

}
