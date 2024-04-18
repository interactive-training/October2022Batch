package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegularPoojasPage {
    public static final Logger log = LogManager.getLogger(RegularPoojasPage.class.getName());
    WebDriver driver;

    // Constructor
    public RegularPoojasPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

//    public Boolean verifyRegularPoojasHeader(){
//        return driver.findElement(By.xpath("//div[@class='container']/h2")).isDisplayed();
//    }


}
