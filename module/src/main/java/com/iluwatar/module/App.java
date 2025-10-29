package com.iluwatar.module;

import java.io.FileNotFoundException;

/**
 * The Module pattern can be considered a Creational pattern and a Structural pattern. It manages
 * the creation and organization of other elements, and groups them as the structural pattern does.
 * An object that applies this pattern can provide the equivalent of a namespace, providing the
 * initialization and finalization process of a static class or a class with static members with
 * cleaner, more concise syntax and semantics.
 *
 * <p>The below example demonstrates a use case for testing two different modules: File Logger and
 * Console Logger
 */
public class App {

  private static final String ERROR = "Error";
  private static final String MESSAGE = "Message";
  public static FileLoggerModule fileLoggerModule;
  public static ConsoleLoggerModule consoleLoggerModule;

  /**
   * Following method performs the initialization.
   *
   * @throws FileNotFoundException if program is not able to find log files (output.txt and
   *                               error.txt)
   */
  public static void prepare() throws FileNotFoundException {

    /* Create new singleton objects and prepare their modules */
    fileLoggerModule = FileLoggerModule.getSingleton().prepare();
    consoleLoggerModule = ConsoleLoggerModule.getSingleton().prepare();
  }

  /**
   * Following method performs the finalization.
   */
  public static void unprepare() {

    /* Close all resources */
    fileLoggerModule.unprepare();
    consoleLoggerModule.unprepare();
  }

  /**
   * Following method is main executor.
   */
  public static void execute() {

    /* Send logs on file system */
    fileLoggerModule.printString(MESSAGE);
    fileLoggerModule.printErrorString(ERROR);

    /* Send logs on console */
    consoleLoggerModule.printString(MESSAGE);
    consoleLoggerModule.printErrorString(ERROR);
  }

  /**
   * Program entry point.
   *
   * @param args command line args.
   * @throws FileNotFoundException if program is not able to find log files (output.txt and
   *                               error.txt)
   */
  public static void main(final String... args) throws FileNotFoundException {
    prepare();
    execute();
    unprepare();
  }
}
