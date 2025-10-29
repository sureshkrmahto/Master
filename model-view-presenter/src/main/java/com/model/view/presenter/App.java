package com.model.view.presenter;

/**
 * The Model-View-Presenter(MVP) architectural pattern, helps us achieve what is called "The
 * separation of concerns" principle. This is accomplished by separating the application's logic
 * (Model), GUIs (View), and finally the way that the user's actions update the application's logic
 * (Presenter).
 *
 * <p>In the following example, The {@link FileLoader} class represents the app's logic, the {@link
 * FileSelectorJFrame} is the GUI and the {@link FileSelectorPresenter} is responsible to respond to
 * users' actions.
 *
 * <p>Finally, please notice the wiring between the Presenter and the View and between the
 * Presenter and the Model.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var loader = new FileLoader();
var frame = new FileSelectorJFrame();
var presenter = new FileSelectorPresenter(frame);
presenter.setLoader(loader);
presenter.start();
  }
}
