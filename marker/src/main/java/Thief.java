import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class defining Thief.
 
 * @author Suresh Mahto

 *  @author Suresh Mahto
 */
public class Thief {
private static final Logger LOGGER = LoggerFactory.getLogger(Thief.class);

protected void steal() {
LOGGER.info("Steal valuable items");
  }

protected void doNothing() {
LOGGER.info("Pretend nothing happened and just leave");
  }
}
