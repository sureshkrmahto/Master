import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Guard test
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class GuardTest {

  @Test
  public void testGuard() {
    var guard = new Guard();
    assertThat(guard, instanceOf(Permission.class));
  }
}