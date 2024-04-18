package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecialPoojasPage {
    public static final Logger log = LogManager.getLogger(SpecialPoojasPage.class.getName());
    WebDriver driver;

    // Constructor
    public SpecialPoojasPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

    public Boolean verifySpecialPoojasHeader(){
        return driver.findElement(By.xpath("//div[@class='container']/h2")).isDisplayed();
    }

}
