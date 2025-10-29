package com.databus.data;

import com.databus.AbstractDataType;
import com.databus.DataType;
import java.time.LocalDateTime;

/**
 * An event raised when applications stops, containing the stop time of the application.
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class StoppingData extends AbstractDataType {

private final LocalDateTime when;

public StoppingData(LocalDateTime when) {
this.when = when;
  }

public LocalDateTime getWhen() {
return when;
  }

public static DataType of(final LocalDateTime when) {
return new StoppingData(when);
  }
}
