package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class NewsLetterSubscriberDetailsPage {
    public static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    WebDriver driver;
    Properties prop;

    // Constructor
    public NewsLetterSubscriberDetailsPage(WebDriver driver){
        //super(driver);
        this.driver = driver;
    }
    public Boolean verifyNewsLetterSubscriberDetailsHeader(){
        return driver.findElement(By.xpath("//h1[text()='News Letter Subscriber Details']")).isDisplayed();
    }
}
