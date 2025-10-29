package com.iluwatar.partialresponse;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Partial response pattern is a design pattern in which client specifies fields to fetch to
 * serve. Here {@link App} is playing as client for {@link VideoResource} server. Client ask for
 * specific fields information in video to server.
 *
 * <p>{@link VideoResource} act as server to serve video information.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class App {
  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Method as act client and request to server for video details.
   *
   * @param args program argument.
   */
  public static void main(String[] args) throws Exception {
    var videos = Map.of(
        1, new Video(1, "Avatar", 178, "epic science fiction film",
            "James Cameron", "English"),
        2, new Video(2, "Godzilla Resurgence", 120, "Action & drama movie|",
            "Hideaki Anno", "Japanese"),
        3, new Video(3, "Interstellar", 169, "Adventure & Sci-Fi",
            "Christopher Nolan", "English")
    );
    var videoResource = new VideoResource(new FieldJsonMapper(), videos);


    LOGGER.info("Retrieving full response from server:-");
    LOGGER.info("Get all video information:");
    var videoDetails = videoResource.getDetails(1);
    LOGGER.info(videoDetails);

    LOGGER.info("----------------------------------------------------------");

    LOGGER.info("Retrieving partial response from server:-");
    LOGGER.info("Get video @id, @title, @director:");
    var specificFieldsDetails = videoResource.getDetails(3, "id", "title", "director");
    LOGGER.info(specificFieldsDetails);

    LOGGER.info("Get video @id, @length:");
    var videoLength = videoResource.getDetails(3, "id", "length");
    LOGGER.info(videoLength);
  }
}
