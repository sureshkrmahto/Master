package com.iluwatar.hexagonal.administration;

import com.google.inject.Guice;
import com.iluwatar.hexagonal.domain.LotteryAdministration;
import com.iluwatar.hexagonal.domain.LotteryService;
import com.iluwatar.hexagonal.module.LotteryModule;
import com.iluwatar.hexagonal.mongo.MongoConnectionPropertiesLoader;
import com.iluwatar.hexagonal.sampledata.SampleData;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Console interface for lottery administration.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ConsoleAdministration {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleAdministration.class);

  /**
   * Program entry point.
   */
  public static void main(String[] args) {
    MongoConnectionPropertiesLoader.load();
    var injector = Guice.createInjector(new LotteryModule());
    var administration = injector.getInstance(LotteryAdministration.class);
    var service = injector.getInstance(LotteryService.class);
    SampleData.submitTickets(service, 20);
    var consoleAdministration = new ConsoleAdministrationSrvImpl(administration, LOGGER);
    try (var scanner = new Scanner(System.in)) {
      var exit = false;
      while (!exit) {
        printMainMenu();
        var cmd = readString(scanner);
        if ("1".equals(cmd)) {
          consoleAdministration.getAllSubmittedTickets();
        } else if ("2".equals(cmd)) {
          consoleAdministration.performLottery();
        } else if ("3".equals(cmd)) {
          consoleAdministration.resetLottery();
        } else if ("4".equals(cmd)) {
          exit = true;
        } else {
          LOGGER.info("Unknown command: {}", cmd);
        }
      }
    }
  }

  private static void printMainMenu() {
    LOGGER.info("");
    LOGGER.info("### Lottery Administration Console ###");
    LOGGER.info("(1) Show all submitted tickets");
    LOGGER.info("(2) Perform lottery draw");
    LOGGER.info("(3) Reset lottery ticket database");
    LOGGER.info("(4) Exit");
  }

  private static String readString(Scanner scanner) {
    LOGGER.info("> ");
    return scanner.next();
  }
}
