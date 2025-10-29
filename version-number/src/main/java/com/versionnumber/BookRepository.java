package com.versionnumber;

import java.util.HashMap;
import java.util.Map;

/**
 * This repository represents simplified database.
 * As a typical database do, repository operates with copies of object.
 * So client and repo has different copies of book, which can lead to concurrency conflicts
 * as much as in real databases.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class BookRepository {
private final Map<Long, Book> collection = new HashMap<>();

  /**
   * Adds book to collection.
   * Actually we are putting copy of book (saving a book by value, not by reference);
 *  @author Suresh Mahto
   */
public void add(Book book) throws BookDuplicateException {
if (collection.containsKey(book.getId())) {
throw new BookDuplicateException("Duplicated book with id: " + book.getId());
    }

    // add copy of the book
collection.put(book.getId(), new Book(book));
  }

  /**
   * Updates book in collection only if client has modified the latest version of the book.
 *  @author Suresh Mahto
   */
public void update(Book book) throws BookNotFoundException, VersionMismatchException {
if (!collection.containsKey(book.getId())) {
throw new BookNotFoundException("Not found book with id: " + book.getId());
    }

var latestBook = collection.get(book.getId());
if (book.getVersion() != latestBook.getVersion()) {
throw new VersionMismatchException(
        "Tried to update stale version " + book.getVersion()
          + " while actual version is " + latestBook.getVersion()
      );
    }

    // update version, including client representation - modify by reference here
book.setVersion(book.getVersion() + 1);

    // save book copy to repository
collection.put(book.getId(), new Book(book));
  }

  /**
   * Returns book representation to the client.
   * Representation means we are returning copy of the book.
 *  @author Suresh Mahto
   */
public Book get(long bookId) throws BookNotFoundException {
if (!collection.containsKey(bookId)) {
throw new BookNotFoundException("Not found book with id: " + bookId);
    }

    // return copy of the book
return new Book(collection.get(bookId));
  }
}
