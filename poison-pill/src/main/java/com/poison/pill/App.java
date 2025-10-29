package com.poison.pill;

/**
 * One of the possible approaches to terminate Producer-Consumer pattern is using the Poison Pill
 * idiom. If you use Poison Pill as the termination signal then Producer is responsible to notify
 * Consumer that the exchange is over and reject any further messages. The Consumer receiving Poison
 * Pill will stop reading messages from the queue. You must also ensure that the Poison Pill will be
 * the last message that will be read from the queue (if you have prioritized queue then this can be
 * tricky).
 *
 * <p>In simple cases the Poison Pill can be just a null-reference, but holding a unique separate
 * shared object-marker (with name "Poison" or "Poison Pill") is more clear and self describing.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
 *  @author Suresh Mahto
   */
public static void main(String[] args) {
var queue = new SimpleMessageQueue(10000);

final var producer = new Producer("PRODUCER_1", queue);
final var consumer = new Consumer("CONSUMER_1", queue);

new Thread(consumer::consume).start();

new Thread(() -> {
producer.send("hand shake");
producer.send("some very important information");
producer.send("bye!");
producer.stop();
    }).start();
  }
}
