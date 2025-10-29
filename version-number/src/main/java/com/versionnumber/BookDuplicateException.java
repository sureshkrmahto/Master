package com.versionnumber;

/**
 * When someone has tried to add a book which repository already have.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class BookDuplicateException extends Exception {
public BookDuplicateException(String message) {
super(message);
  }
}
