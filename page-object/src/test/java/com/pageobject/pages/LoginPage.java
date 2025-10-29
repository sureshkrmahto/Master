package com.pageobject.pages;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;

/**
 * Page Object encapsulating the Login Page (login.html)
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class LoginPage extends Page {

private static final String LOGIN_PAGE_HTML_FILE = "login.html";
private static final String PAGE_URL = "file:" + AUT_PATH + LOGIN_PAGE_HTML_FILE;

private HtmlPage page;

  /**
   * Constructor
   *
   * @param webClient {@link WebClient}
 *  @author Suresh Mahto
   */
public LoginPage(WebClient webClient) {
super(webClient);
  }

  /**
   * Navigates to the Login page
   *
   * @return {@link LoginPage}
 *  @author Suresh Mahto
   */
public LoginPage navigateToPage() {
try {
page = this.webClient.getPage(PAGE_URL);
    } catch (IOException e) {
e.printStackTrace();
    }
return this;
  }

  /**
   * {@inheritDoc}
 *  @author Suresh Mahto
   */
  @Override
public boolean isAt() {
return "Login".equals(page.getTitleText());
  }


  /**
   * Enters the username into the username input text field
   *
   * @param username the username to enter
   * @return {@link LoginPage}
 *  @author Suresh Mahto
   */
public LoginPage enterUsername(String username) {
var usernameInputTextField = (HtmlTextInput) page.getElementById("username");
usernameInputTextField.setText(username);
return this;
  }


  /**
   * Enters the password into the password input password field
   *
   * @param password the password to enter
   * @return {@link LoginPage}
 *  @author Suresh Mahto
   */
public LoginPage enterPassword(String password) {
var passwordInputPasswordField = (HtmlPasswordInput) page.getElementById("password");
passwordInputPasswordField.setText(password);
return this;
  }


  /**
   * Clicking on the login button to 'login'
   *
   * @return {@link AlbumListPage} - this is the page that user gets navigated to once successfully
   *     logged in
 *  @author Suresh Mahto
   */
public AlbumListPage login() {
var loginButton = (HtmlSubmitInput) page.getElementById("loginButton");
try {
loginButton.click();
    } catch (IOException e) {
e.printStackTrace();
    }
return new AlbumListPage(webClient);
  }

}
