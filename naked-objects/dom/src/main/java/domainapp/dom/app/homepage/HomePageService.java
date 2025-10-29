package domainapp.dom.app.homepage;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.HomePage;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.SemanticsOf;

/**
 * HomePage Domain Service.
 *
 * @see HomePageViewModel linked view to HomePage
 */
@DomainService(nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY)
public class HomePageService {

  // endregion

  // region > injected services

  @javax.inject.Inject
  DomainObjectContainer container;

  // endregion

  // region > homePage (action)

  @Action(semantics = SemanticsOf.SAFE)
  @HomePage
  public HomePageViewModel homePage() {
    return container.injectServicesInto(new HomePageViewModel());
  }

}
