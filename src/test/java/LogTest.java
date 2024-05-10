import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogTest {

    public  static Logger LOGGER = LogManager.getLogger(LogTest.class);

//    1. warn -- root level
//            Error

    @Test
    public void testlog(){
        System.out.println("log file generated");

        LOGGER.fatal("Fatal error");
        LOGGER.error("Log message written");
        LOGGER.info("Log message written");
        LOGGER.debug("Log message written");

    }
}
