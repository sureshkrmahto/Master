package com.iluwatar.versionnumber;

/**
 * When someone has tried to add a book which repository already have.
 */
public class BookDuplicateException extends Exception {
  public BookDuplicateException(String message) {
    super(message);
  }
}
