package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogMe {

    private static Logger logger = LogManager.getLogger(LogMe.class.getName());

    public static Logger getMyLogger(Object obj){
        logger = LogManager.getLogger(obj);
        return logger;
    }

}
