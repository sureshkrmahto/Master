package com.iluwatar.servant;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Suresh Mahto
 */
public class ServantTest {

  @Test
  public void testFeed() {
    final var royalty = mock(Royalty.class);
    final var servant = new Servant("test");
    servant.feed(royalty);
    verify(royalty).getFed();
    verifyNoMoreInteractions(royalty);
  }

  @Test
  public void testGiveWine() {
    final var royalty = mock(Royalty.class);
    final var servant = new Servant("test");
    servant.giveWine(royalty);
    verify(royalty).getDrink();
    verifyNoMoreInteractions(royalty);
  }

  @Test
  public void testGiveCompliments() {
    final var royalty = mock(Royalty.class);
    final var servant = new Servant("test");
    servant.giveCompliments(royalty);
    verify(royalty).receiveCompliments();
    verifyNoMoreInteractions(royalty);
  }

  @Test
  public void testCheckIfYouWillBeHanged() {
    final var goodMoodRoyalty = mock(Royalty.class);
    when(goodMoodRoyalty.getMood()).thenReturn(true);

    final var badMoodRoyalty = mock(Royalty.class);
    when(badMoodRoyalty.getMood()).thenReturn(true);

    final var goodCompany = List.of(goodMoodRoyalty, goodMoodRoyalty, goodMoodRoyalty);

    final var badCompany = List.of(goodMoodRoyalty, goodMoodRoyalty, badMoodRoyalty);

    assertTrue(new Servant("test").checkIfYouWillBeHanged(goodCompany));
    assertTrue(new Servant("test").checkIfYouWillBeHanged(badCompany));

  }

}