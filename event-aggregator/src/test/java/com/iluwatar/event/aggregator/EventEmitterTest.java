package com.iluwatar.event.aggregator;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

/**
 *
 * @param <E> Type of Event Emitter
 * @author Suresh Mahto
 *  @author Suresh Mahto
 */
public abstract class EventEmitterTest<E extends EventEmitter> {

  /**
   * Factory used to create a new instance of the test object with a default observer
 *  @author Suresh Mahto
   */
private final Function<EventObserver, E> factoryWithDefaultObserver;

  /**
   * Factory used to create a new instance of the test object without passing a default observer
 *  @author Suresh Mahto
   */
private final Supplier<E> factoryWithoutDefaultObserver;

  /**
   * The day of the week an event is expected
 *  @author Suresh Mahto
   */
private final Weekday specialDay;

  /**
   * The expected event, emitted on the special day
 *  @author Suresh Mahto
   */
private final Event event;

  /**
   * Create a new event emitter test, using the given test object factories, special day and event
*/
EventEmitterTest(final Weekday specialDay, final Event event,
final Function<EventObserver, E> factoryWithDefaultObserver,
final Supplier<E> factoryWithoutDefaultObserver) {

this.specialDay = specialDay;
this.event = event;
this.factoryWithDefaultObserver = Objects.requireNonNull(factoryWithDefaultObserver);
this.factoryWithoutDefaultObserver = Objects.requireNonNull(factoryWithoutDefaultObserver);
  }

  /**
   * Go over every day of the month, and check if the event is emitted on the given day. This test
   * is executed twice, once without a default emitter and once with
 *  @author Suresh Mahto
   */
  @Test
public void testAllDays() {
testAllDaysWithoutDefaultObserver(specialDay, event);
testAllDaysWithDefaultObserver(specialDay, event);
  }

  /**
   * Pass each week of the day, day by day to the event emitter and verify of the given observers
   * received the correct event on the special day.
   *
   * @param specialDay The special day on which an event is emitted
   * @param event      The expected event emitted by the test object
   * @param emitter    The event emitter
   * @param observers  The registered observer mocks
 *  @author Suresh Mahto
   */
private void testAllDays(final Weekday specialDay, final Event event, final E emitter,
final EventObserver... observers) {

for (final var weekday : Weekday.values()) {
      // Pass each week of the day, day by day to the event emitter
emitter.timePasses(weekday);

if (weekday == specialDay) {
        // On a special day, every observer should have received the event
for (final var observer : observers) {
verify(observer, times(1)).onEvent(eq(event));
        }
      } else {
        // On any other normal day, the observers should have received nothing at all
verifyZeroInteractions(observers);
      }
    }

    // The observers should not have received any additional events after the week
verifyNoMoreInteractions(observers);
  }

  /**
   * Go over every day of the month, and check if the event is emitted on the given day. Use an
   * event emitter without a default observer
   *
   * @param specialDay The special day on which an event is emitted
   * @param event      The expected event emitted by the test object
 *  @author Suresh Mahto
   */
private void testAllDaysWithoutDefaultObserver(final Weekday specialDay, final Event event) {
final var observer1 = mock(EventObserver.class);
final var observer2 = mock(EventObserver.class);

final var emitter = this.factoryWithoutDefaultObserver.get();
emitter.registerObserver(observer1);
emitter.registerObserver(observer2);

testAllDays(specialDay, event, emitter, observer1, observer2);
  }

  /**
   * Go over every day of the month, and check if the event is emitted on the given day.
   *
   * @param specialDay The special day on which an event is emitted
   * @param event      The expected event emitted by the test object
 *  @author Suresh Mahto
   */
private void testAllDaysWithDefaultObserver(final Weekday specialDay, final Event event) {
final var defaultObserver = mock(EventObserver.class);
final var observer1 = mock(EventObserver.class);
final var observer2 = mock(EventObserver.class);

final var emitter = this.factoryWithDefaultObserver.apply(defaultObserver);
emitter.registerObserver(observer1);
emitter.registerObserver(observer2);

testAllDays(specialDay, event, emitter, defaultObserver, observer1, observer2);
  }

}
