package com.iluwatar.versionnumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link BookRepository}
 */
class BookRepositoryTest {
  private final long bookId = 1;
  private final BookRepository bookRepository = new BookRepository();

  @BeforeEach
  public void setUp() throws BookDuplicateException {
    var book = new Book();
    book.setId(bookId);
    bookRepository.add(book);
  }

  @Test
  void testDefaultVersionRemainsZeroAfterAdd() throws BookNotFoundException {
    var book = bookRepository.get(bookId);
    assertEquals(0, book.getVersion());
  }

  @Test
  void testAliceAndBobHaveDifferentVersionsAfterAliceUpdate() throws BookNotFoundException, VersionMismatchException {
    final var aliceBook = bookRepository.get(bookId);
    final var bobBook = bookRepository.get(bookId);

    aliceBook.setTitle("Kama Sutra");
    bookRepository.update(aliceBook);

    assertEquals(1, aliceBook.getVersion());
    assertEquals(0, bobBook.getVersion());
    var actualBook = bookRepository.get(bookId);
    assertEquals(aliceBook.getVersion(), actualBook.getVersion());
    assertEquals(aliceBook.getTitle(), actualBook.getTitle());
    assertNotEquals(aliceBook.getTitle(), bobBook.getTitle());
  }

  @Test
  void testShouldThrowVersionMismatchExceptionOnStaleUpdate() throws BookNotFoundException, VersionMismatchException {
    final var aliceBook = bookRepository.get(bookId);
    final var bobBook = bookRepository.get(bookId);

    aliceBook.setTitle("Kama Sutra");
    bookRepository.update(aliceBook);

    bobBook.setAuthor("Vatsyayana Mallanaga");
    try {
      bookRepository.update(bobBook);
    } catch (VersionMismatchException e) {
      assertEquals(0, bobBook.getVersion());
      var actualBook = bookRepository.get(bookId);
      assertEquals(1, actualBook.getVersion());
      assertEquals(aliceBook.getVersion(), actualBook.getVersion());
      assertEquals("", bobBook.getTitle());
      assertNotEquals(aliceBook.getAuthor(), bobBook.getAuthor());
    }
  }
}
