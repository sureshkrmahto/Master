package com.iluwatar.partialresponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * tests {@link FieldJsonMapper}.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
class FieldJsonMapperTest {
private static FieldJsonMapper mapper;

@BeforeAll
static void setUp() {
mapper = new FieldJsonMapper();
  }

@Test
void shouldReturnJsonForSpecifiedFieldsInVideo() throws Exception {
var fields = new String[]{"id", "title", "length"};
var video = new Video(
2, "Godzilla Resurgence", 120,
        "Action & drama movie|", "Hideaki Anno", "Japanese"
    );

var jsonFieldResponse = mapper.toJson(video, fields);

var expectedDetails = "{\"id\": 2,\"title\": \"Godzilla Resurgence\",\"length\": 120}";
Assertions.assertEquals(expectedDetails, jsonFieldResponse);
  }
}