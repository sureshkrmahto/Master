import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Thief test
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class ThiefTest {
  @Test
  public void testThief() {
    var thief = new Thief();
    assertThat(thief, not(instanceOf(Permission.class)));
  }
}