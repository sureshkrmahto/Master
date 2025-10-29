package com.databus.data;

import com.databus.AbstractDataType;
import com.databus.DataType;

/**
 * An event raised when a string message is sent.
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class MessageData extends AbstractDataType {

private final String message;

public MessageData(String message) {
this.message = message;
  }

public String getMessage() {
return message;
  }

public static DataType of(final String message) {
return new MessageData(message);
  }
}
