package com.iluwatar.versionnumber;

/**
 * Client has tried to make an operation with book which repository does not have.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class BookNotFoundException extends Exception {
public BookNotFoundException(String message) {
super(message);
  }
}
