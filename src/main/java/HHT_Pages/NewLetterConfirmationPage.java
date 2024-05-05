package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLetterConfirmationPage {
    public static final Logger log = LogManager.getLogger(News_AddNewsDetailsPage.class.getName());

    WebDriver driver;
    public NewLetterConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables
    public Boolean verifyAddNewsLetterHeader(){
        return driver.findElement(By.xpath("//h1[@class='sucesstext']")).isDisplayed();
    }
}
