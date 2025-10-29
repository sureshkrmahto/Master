package com.iluwatar.model.view.presenter;

import java.io.Serializable;

/**
 * This interface represents the View component in the Model-View-Presenter pattern. It can be
 * implemented by either the GUI components, or by the Stub.
 *  @author Suresh Mahto
 */
public interface FileSelectorView extends Serializable {

  /**
   * Opens the view.
*/
void open();

  /**
   * Closes the view.
*/
void close();

  /**
   * Returns true if view is opened.
   *
   * @return True, if the view is opened, false otherwise.
*/
boolean isOpened();

  /**
   * Sets the presenter component, to the one given as parameter.
   *
   * @param presenter The new presenter component.
*/
void setPresenter(FileSelectorPresenter presenter);

  /**
   * Gets presenter component.
   *
   * @return The presenter Component.
*/
FileSelectorPresenter getPresenter();

  /**
   * Sets the file's name, to the value given as parameter.
   *
   * @param name The new name of the file.
*/
void setFileName(String name);

  /**
   * Gets the name of file.
   *
   * @return The name of the file.
*/
String getFileName();

  /**
   * Displays a message to the users.
   *
   * @param message The message to be displayed.
*/
void showMessage(String message);

  /**
   * Displays the data to the view.
   *
   * @param data The data to be written.
*/
void displayData(String data);
}
