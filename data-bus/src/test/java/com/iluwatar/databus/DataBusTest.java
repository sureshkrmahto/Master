package com.iluwatar.databus;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Tests for {@link DataBus}.
 *
 * @author Suresh Mahto
 */
public class DataBusTest {

  @Mock
  private Member member;

  @Mock
  private DataType event;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void publishedEventIsReceivedBySubscribedMember() {
    //given
    final var dataBus = DataBus.getInstance();
    dataBus.subscribe(member);
    //when
    dataBus.publish(event);
    //then
    then(member).should().accept(event);
  }

  @Test
  public void publishedEventIsNotReceivedByMemberAfterUnsubscribing() {
    //given
    final var dataBus = DataBus.getInstance();
    dataBus.subscribe(member);
    dataBus.unsubscribe(member);
    //when
    dataBus.publish(event);
    //then
    then(member).should(never()).accept(event);
  }

}
