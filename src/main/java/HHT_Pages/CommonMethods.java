package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CommonMethods {
    public static final Logger log = LogManager.getLogger(CalendarPage.class.getName());
    WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    //By variables
}
