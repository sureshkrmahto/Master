import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class defining Guard.
 
 * @author Suresh Mahto

 */
/**
 * @author Suresh Mahto
 */
public class Guard implements Permission {
  private static final Logger LOGGER = LoggerFactory.getLogger(Guard.class);

  protected void enter() {
    LOGGER.info("You can enter");
  }
}
