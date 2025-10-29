package com.pageobject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gargoylesoftware.htmlunit.WebClient;
import com.pageobject.pages.AlbumListPage;
import com.pageobject.pages.AlbumPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Album Selection and Album Listing
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AlbumListPageTest {

private final AlbumListPage albumListPage = new AlbumListPage(new WebClient());

@BeforeEach
public void setUp() {
albumListPage.navigateToPage();
  }

@Test
public void testSelectAlbum() {
var albumPage = albumListPage.selectAlbum("21");
albumPage.navigateToPage();
assertTrue(albumPage.isAt());
  }

}
