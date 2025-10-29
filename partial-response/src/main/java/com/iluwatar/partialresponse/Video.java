package com.iluwatar.partialresponse;

/**
 * {@link Video} is a entity to serve from server.It contains all video related information.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Video {
  private final Integer id;
  private final String title;
  private final Integer length;
  private final String description;
  private final String director;
  private final String language;

  /**
   * Constructor.
   *
   * @param id       video unique id
   * @param title    video title
   * @param len      video length in minutes
   * @param desc     video description by publisher
   * @param director video director name
   * @param lang     video language {private, public}
   */
  public Video(Integer id, String title, Integer len, String desc, String director, String lang) {
    this.id = id;
    this.title = title;
    this.length = len;
    this.description = desc;
    this.director = director;
    this.language = lang;
  }

  /**
   * ToString.
   *
   * @return json representaion of video
   */
  @Override
  public String toString() {
    return "{"
        + "\"id\": " + id + ","
        + "\"title\": \"" + title + "\","
        + "\"length\": " + length + ","
        + "\"description\": \"" + description + "\","
        + "\"director\": \"" + director + "\","
        + "\"language\": \"" + language + "\","
        + "}";
  }
}
