package com.iluwatar.pageobject.pages;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlNumberInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;

/**
 * Page Object encapsulating the Album Page (album-page.html)
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AlbumPage extends Page {

private static final String ALBUM_PAGE_HTML_FILE = "album-page.html";
private static final String PAGE_URL = "file:" + AUT_PATH + ALBUM_PAGE_HTML_FILE;

private HtmlPage page;


  /**
   * Constructor
 *  @author Suresh Mahto
   */
public AlbumPage(WebClient webClient) {
super(webClient);
  }


  /**
   * Navigates to the album page
   *
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage navigateToPage() {
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
return "Album Page".equals(page.getTitleText());
  }


  /**
   * Sets the album title input text field
   *
   * @param albumTitle the new album title value to set
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage changeAlbumTitle(String albumTitle) {
var albumTitleInputTextField = (HtmlTextInput) page.getElementById("albumTitle");
albumTitleInputTextField.setText(albumTitle);
return this;
  }


  /**
   * Sets the artist input text field
   *
   * @param artist the new artist value to set
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage changeArtist(String artist) {
var artistInputTextField = (HtmlTextInput) page.getElementById("albumArtist");
artistInputTextField.setText(artist);
return this;
  }


  /**
   * Selects the select's option value based on the year value given
   *
   * @param year the new year value to set
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage changeAlbumYear(int year) {
var albumYearSelectOption = (HtmlSelect) page.getElementById("albumYear");
var yearOption = albumYearSelectOption.getOptionByValue(Integer.toString(year));
albumYearSelectOption.setSelectedAttribute(yearOption, true);
return this;
  }


  /**
   * Sets the album rating input text field
   *
   * @param albumRating the new album rating value to set
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage changeAlbumRating(String albumRating) {
var albumRatingInputTextField = (HtmlTextInput) page.getElementById("albumRating");
albumRatingInputTextField.setText(albumRating);
return this;
  }

  /**
   * Sets the number of songs number input field
   *
   * @param numberOfSongs the new number of songs value to be set
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage changeNumberOfSongs(int numberOfSongs) {
var numberOfSongsNumberField = (HtmlNumberInput) page.getElementById("numberOfSongs");
numberOfSongsNumberField.setText(Integer.toString(numberOfSongs));
return this;
  }


  /**
   * Cancel changes made by clicking the cancel button
   *
   * @return {@link AlbumListPage}
 *  @author Suresh Mahto
   */
public AlbumListPage cancelChanges() {
var cancelButton = (HtmlSubmitInput) page.getElementById("cancelButton");
try {
cancelButton.click();
    } catch (IOException e) {
e.printStackTrace();
    }
return new AlbumListPage(webClient);
  }


  /**
   * Saves changes made by clicking the save button
   *
   * @return {@link AlbumPage}
 *  @author Suresh Mahto
   */
public AlbumPage saveChanges() {
var saveButton = (HtmlSubmitInput) page.getElementById("saveButton");
try {
saveButton.click();
    } catch (IOException e) {
e.printStackTrace();
    }
return this;
  }

}
