package com.iluwatar.partialresponse;

import java.lang.reflect.Field;

/**
 * Map a video to json.
 */
public class FieldJsonMapper {

  /**
   * Gets json of required fields from video.
   *
   * @param video  object containing video information
   * @param fields fields information to get
   * @return json of required fields from video
   */
  public String toJson(Video video, String[] fields) throws Exception {
    var json = new StringBuilder().append("{");

    var i = 0;
    var fieldsLength = fields.length;
    while (i < fieldsLength) {
      json.append(getString(video, Video.class.getDeclaredField(fields[i])));
      if (i != fieldsLength - 1) {
        json.append(",");
      }
      i++;
    }
    json.append("}");
    return json.toString();
  }

  private String getString(Video video, Field declaredField) throws IllegalAccessException {
    declaredField.setAccessible(true);
    var value = declaredField.get(video);
    if (declaredField.get(video) instanceof Integer) {
      return "\"" + declaredField.getName() + "\"" + ": " + value;
    }
    return "\"" + declaredField.getName() + "\"" + ": " + "\"" + value.toString() + "\"";
  }
}
