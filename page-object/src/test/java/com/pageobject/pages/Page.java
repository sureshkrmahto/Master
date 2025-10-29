package com.pageobject.pages;

import com.gargoylesoftware.htmlunit.WebClient;

/**
 * Encapsulation for a generic 'Page'
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public abstract class Page {

  /**
   * Application Under Test path This directory location is where html web pages are located
 *  @author Suresh Mahto
   */
public static final String AUT_PATH = "src/main/resources/sample-ui/";

protected final WebClient webClient;

  /**
   * Constructor
   *
   * @param webClient {@link WebClient}
 *  @author Suresh Mahto
   */
public Page(WebClient webClient) {
this.webClient = webClient;
  }

  /**
   * Checks that the current page is actually the page this page object represents
   *
   * @return true if so, otherwise false
 *  @author Suresh Mahto
   */
public abstract boolean isAt();


}
