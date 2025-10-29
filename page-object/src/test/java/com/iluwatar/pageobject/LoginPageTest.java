package com.iluwatar.pageobject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gargoylesoftware.htmlunit.WebClient;
import com.iluwatar.pageobject.pages.AlbumListPage;
import com.iluwatar.pageobject.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Login Page Object
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class LoginPageTest {

  private final LoginPage loginPage = new LoginPage(new WebClient());

  @BeforeEach
  public void setUp() {
    loginPage.navigateToPage();
  }

  @Test
  public void testLogin() {
    var albumListPage = loginPage
        .enterUsername("admin")
        .enterPassword("password")
        .login();
    albumListPage.navigateToPage();
    assertTrue(albumListPage.isAt());
  }

}
