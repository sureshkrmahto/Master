package com.iluwatar.model.view.presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Every instance of this class represents the Model component in the Model-View-Presenter
 * architectural pattern.
 *
 * <p>It is responsible for reading and loading the contents of a given file.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class FileLoader implements Serializable {

  /**
   * Generated serial version UID.
 *  @author Suresh Mahto
   */
private static final long serialVersionUID = -4745803872902019069L;

private static final Logger LOGGER = LoggerFactory.getLogger(FileLoader.class);

  /**
   * Indicates if the file is loaded or not.
 *  @author Suresh Mahto
   */
private boolean loaded;

  /**
   * The name of the file that we want to load.
 *  @author Suresh Mahto
   */
private String fileName;

  /**
   * Loads the data of the file specified.
 *  @author Suresh Mahto
   */
public String loadData() {
var dataFileName = this.fileName;
try (var br = new BufferedReader(new FileReader(new File(dataFileName)))) {
var result = br.lines().collect(Collectors.joining("\n"));
this.loaded = true;
return result;
    } catch (Exception e) {
LOGGER.error("File {} does not exist", dataFileName);
    }

return null;
  }

  /**
   * Sets the path of the file to be loaded, to the given value.
   *
   * @param fileName The path of the file to be loaded.
 *  @author Suresh Mahto
   */
public void setFileName(String fileName) {
this.fileName = fileName;
  }

  /**
   * Gets the path of the file to be loaded.
   *
   * @return fileName The path of the file to be loaded.
 *  @author Suresh Mahto
   */
public String getFileName() {
return this.fileName;
  }

  /**
   * Returns true if the given file exists.
   *
   * @return True, if the file given exists, false otherwise.
 *  @author Suresh Mahto
   */
public boolean fileExists() {
return new File(this.fileName).exists();
  }

  /**
   * Returns true if the given file is loaded.
   *
   * @return True, if the file is loaded, false otherwise.
 *  @author Suresh Mahto
   */
public boolean isLoaded() {
return this.loaded;
  }
}
