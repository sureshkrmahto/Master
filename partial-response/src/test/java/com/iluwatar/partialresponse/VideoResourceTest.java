package com.iluwatar.partialresponse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

/**
 * tests {@link VideoResource}.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
@ExtendWith(MockitoExtension.class)
class VideoResourceTest {
@Mock
private static FieldJsonMapper fieldJsonMapper;

private static VideoResource resource;

@BeforeAll
static void setUp() {
var videos = Map.of(
1, new Video(1, "Avatar", 178, "epic science fiction film",
            "James Cameron", "English"),
2, new Video(2, "Godzilla Resurgence", 120, "Action & drama movie|",
            "Hideaki Anno", "Japanese"),
3, new Video(3, "Interstellar", 169, "Adventure & Sci-Fi",
            "Christopher Nolan", "English"));
resource = new VideoResource(fieldJsonMapper, videos);
  }

@Test
void shouldGiveVideoDetailsById() throws Exception {
var actualDetails = resource.getDetails(1);

var expectedDetails = "{\"id\": 1,\"title\": \"Avatar\",\"length\": 178,\"description\": "
        + "\"epic science fiction film\",\"director\": \"James Cameron\",\"language\": \"English\",}";
Assertions.assertEquals(expectedDetails, actualDetails);
  }

@Test
void shouldGiveSpecifiedFieldsInformationOfVideo() throws Exception {
var fields = new String[]{"id", "title", "length"};

var expectedDetails = "{\"id\": 1,\"title\": \"Avatar\",\"length\": 178}";
Mockito.when(fieldJsonMapper.toJson(Matchers.any(Video.class), Matchers.eq(fields))).thenReturn(expectedDetails);

var actualFieldsDetails = resource.getDetails(2, fields);

Assertions.assertEquals(expectedDetails, actualFieldsDetails);
  }
}