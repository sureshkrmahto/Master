package com.partialresponse;

import java.util.Map;

/**
 * The resource class which serves video information. This class act as server in the demo. Which
 * has all video details.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class VideoResource {
private final FieldJsonMapper fieldJsonMapper;
private final Map<Integer, Video> videos;

  /**
   * Constructor.
   *
   * @param fieldJsonMapper map object to json.
   * @param videos          initialize resource with existing videos. Act as database.
 *  @author Suresh Mahto
   */
public VideoResource(FieldJsonMapper fieldJsonMapper, Map<Integer, Video> videos) {
this.fieldJsonMapper = fieldJsonMapper;
this.videos = videos;
  }

  /**
   * Get Details.
   *
   * @param id     video id
   * @param fields fields to get information about
   * @return full response if no fields specified else partial response for given field.
 *  @author Suresh Mahto
   */
public String getDetails(Integer id, String... fields) throws Exception {
if (fields.length == 0) {
return videos.get(id).toString();
    }
return fieldJsonMapper.toJson(videos.get(id), fields);
  }
}
