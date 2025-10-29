package com.iluwatar.databus.members;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.iluwatar.databus.DataBus;
import com.iluwatar.databus.data.MessageData;
import com.iluwatar.databus.data.StartingData;
import com.iluwatar.databus.data.StoppingData;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link StatusMember}.
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class StatusMemberTest {

  @Test
  public void statusRecordsTheStartTime() {
    //given
    final var startTime = LocalDateTime.of(2017, Month.APRIL, 1, 19, 9);
    final var startingData = new StartingData(startTime);
    final var statusMember = new StatusMember(1);
    //when
    statusMember.accept(startingData);
    //then
    assertEquals(startTime, statusMember.getStarted());
  }

  @Test
  public void statusRecordsTheStopTime() {
    //given
    final var stop = LocalDateTime.of(2017, Month.APRIL, 1, 19, 12);
    final var stoppingData = new StoppingData(stop);
    stoppingData.setDataBus(DataBus.getInstance());
    final var statusMember = new StatusMember(1);
    //when
    statusMember.accept(stoppingData);
    //then
    assertEquals(stop, statusMember.getStopped());
  }

  @Test
  public void statusIgnoresMessageData() {
    //given
    final var messageData = new MessageData("message");
    final var statusMember = new StatusMember(1);
    //when
    statusMember.accept(messageData);
    //then
    assertNull(statusMember.getStarted());
    assertNull(statusMember.getStopped());
  }

}
