package com.iluwatar.versionnumber;

/**
 * Client has tried to update a stale version of the book.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class VersionMismatchException extends Exception {
public VersionMismatchException(String message) {
super(message);
  }
}
