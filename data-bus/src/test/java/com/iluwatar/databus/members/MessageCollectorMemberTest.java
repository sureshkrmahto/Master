package com.iluwatar.databus.members;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.databus.data.MessageData;
import com.iluwatar.databus.data.StartingData;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link MessageCollectorMember}.
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class MessageCollectorMemberTest {

  @Test
  public void collectMessageFromMessageData() {
    //given
    final var message = "message";
    final var messageData = new MessageData(message);
    final var collector = new MessageCollectorMember("collector");
    //when
    collector.accept(messageData);
    //then
    assertTrue(collector.getMessages().contains(message));
  }

  @Test
  public void collectIgnoresMessageFromOtherDataTypes() {
    //given
    final var startingData = new StartingData(LocalDateTime.now());
    final var collector = new MessageCollectorMember("collector");
    //when
    collector.accept(startingData);
    //then
    assertEquals(0, collector.getMessages().size());
  }

}
