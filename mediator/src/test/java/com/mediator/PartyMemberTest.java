package com.mediator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public class PartyMemberTest {

static Stream<Arguments> dataProvider() {
return Stream.of(
Arguments.of((Supplier<PartyMember>) Hobbit::new),
Arguments.of((Supplier<PartyMember>) Hunter::new),
Arguments.of((Supplier<PartyMember>) Rogue::new),
Arguments.of((Supplier<PartyMember>) Wizard::new)
    );
  }

private InMemoryAppender appender;


@BeforeEach
public void setUp() {
appender = new InMemoryAppender(PartyMemberBase.class);
  }

@AfterEach
public void tearDown() {
appender.stop();
  }

  /**
   * Verify if a party action triggers the correct output to the std-Out
 *  @author Suresh Mahto
   */
  @ParameterizedTest
  @MethodSource("dataProvider")
public void testPartyAction(Supplier<PartyMember> memberSupplier) {
final var member = memberSupplier.get();

for (final var action : Action.values()) {
member.partyAction(action);
assertEquals(member.toString() + " " + action.getDescription(), appender.getLastMessage());
    }

assertEquals(Action.values().length, appender.getLogSize());
  }

  /**
   * Verify if a member action triggers the expected interactions with the party class
 *  @author Suresh Mahto
   */
  @ParameterizedTest
  @MethodSource("dataProvider")
public void testAct(Supplier<PartyMember> memberSupplier) {
final var member = memberSupplier.get();

member.act(Action.GOLD);
assertEquals(0, appender.getLogSize());

final var party = mock(Party.class);
member.joinedParty(party);
assertEquals(member.toString() + " joins the party", appender.getLastMessage());

for (final var action : Action.values()) {
member.act(action);
assertEquals(member.toString() + " " + action.toString(), appender.getLastMessage());
verify(party).act(member, action);
    }

assertEquals(Action.values().length + 1, appender.getLogSize());
  }

  /**
   * Verify if {@link PartyMemberBase#toString()} generate the expected output
 *  @author Suresh Mahto
   */
  @ParameterizedTest
  @MethodSource("dataProvider")
public void testToString(Supplier<PartyMember> memberSupplier) {
final var member = memberSupplier.get();
final var memberClass = member.getClass();
assertEquals(memberClass.getSimpleName(), member.toString());
  }

private static class InMemoryAppender extends AppenderBase<ILoggingEvent> {
private final List<ILoggingEvent> log = new LinkedList<>();

public InMemoryAppender(Class<?> clazz) {
      ((Logger) LoggerFactory.getLogger(clazz)).addAppender(this);
start();
    }

@Override
protected void append(ILoggingEvent eventObject) {
log.add(eventObject);
    }

public int getLogSize() {
return log.size();
    }

public String getLastMessage() {
return log.get(log.size() - 1).getFormattedMessage();
    }
  }


}
