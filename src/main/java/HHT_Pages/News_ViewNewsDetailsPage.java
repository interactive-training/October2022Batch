package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class News_ViewNewsDetailsPage {
    public static final Logger log = LogManager.getLogger(News_ViewNewsDetailsPage.class.getName());
    WebDriver driver;

    public News_ViewNewsDetailsPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

// Methods
    public Boolean verifyViewNewsDetailsHeader(){
        return driver.findElement(By.xpath("(//div[@id='bar']/h1)")).isDisplayed();
    }

}
