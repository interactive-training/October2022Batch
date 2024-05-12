import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4JDemo_Understand_first {

    private  static Logger LOGGER = LogManager.getLogger(Log4JDemo_Understand_first.class);

//    1. warn -- root level
//            Error

    @Test
    public void testlog(){
        System.out.println("log file generated");

        LOGGER.fatal("Fatal error");
        LOGGER.error("error message written");
        LOGGER.info("info message written");
        LOGGER.debug("debug message written");

    }
}
