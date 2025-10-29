package com.poison.pill;

import java.util.Map;

/**
 * Interface that implements the Message pattern and represents an inbound or outbound message as
 * part of an {@link Producer}-{@link Consumer} exchange.
 *  @author Suresh Mahto
 */
public interface Message {

Message POISON_PILL = new Message() {

@Override
public void addHeader(Headers header, String value) {
throw poison();
    }

@Override
public String getHeader(Headers header) {
throw poison();
    }

@Override
public Map<Headers, String> getHeaders() {
throw poison();
    }

@Override
public void setBody(String body) {
throw poison();
    }

@Override
public String getBody() {
throw poison();
    }

private RuntimeException poison() {
return new UnsupportedOperationException("Poison");
    }

  };

  /**
   * Enumeration of Type of Headers.
 *  @author Suresh Mahto
   */
enum Headers {
DATE, SENDER
  }

void addHeader(Headers header, String value);

String getHeader(Headers header);

Map<Headers, String> getHeaders();

void setBody(String body);

String getBody();
}
