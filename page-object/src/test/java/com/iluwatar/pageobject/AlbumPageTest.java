package com.iluwatar.pageobject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gargoylesoftware.htmlunit.WebClient;
import com.iluwatar.pageobject.pages.AlbumListPage;
import com.iluwatar.pageobject.pages.AlbumPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Album Page Operations
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class AlbumPageTest {

private final AlbumPage albumPage = new AlbumPage(new WebClient());

@BeforeEach
public void setUp() {
albumPage.navigateToPage();
  }

@Test
public void testSaveAlbum() {

var albumPageAfterChanges = albumPage
        .changeAlbumTitle("25")
        .changeArtist("Adele Laurie Blue Adkins")
        .changeAlbumYear(2015)
        .changeAlbumRating("B")
        .changeNumberOfSongs(20)
        .saveChanges();

assertTrue(albumPageAfterChanges.isAt());

  }

@Test
public void testCancelChanges() {
var albumListPage = albumPage.cancelChanges();
albumListPage.navigateToPage();
assertTrue(albumListPage.isAt());
  }

}
