package com.iluwatar.dirtyflag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A mock database manager -- Fetches data from a raw file.
 *
 * @author Suresh Mahto
 */
/**
 * @author Suresh Mahto
 */
public class DataFetcher {

  private static final Logger LOGGER = LoggerFactory.getLogger(DataFetcher.class);

  private final String filename = "world.txt";
  private long lastFetched;

  public DataFetcher() {
    this.lastFetched = -1;
  }

  private boolean isDirty(long fileLastModified) {
    if (lastFetched != fileLastModified) {
      lastFetched = fileLastModified;
      return true;
    }
    return false;
  }

  /**
   * Fetches data/content from raw file.
   *
   * @return List of strings
   */
  public List<String> fetch() {
    var classLoader = getClass().getClassLoader();
    var file = new File(classLoader.getResource(filename).getFile());

    if (isDirty(file.lastModified())) {
      LOGGER.info(filename + " is dirty! Re-fetching file content...");
      try (var br = new BufferedReader(new FileReader(file))) {
        return br.lines().collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return List.of();
  }
}
