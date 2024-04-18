package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Poojas_ViewPoojasDetails {
    public static final Logger log = LogManager.getLogger(Poojas_ViewPoojasDetails.class.getName());
    WebDriver driver;

    // Constructor
    public Poojas_ViewPoojasDetails(WebDriver driver){
        this.driver = driver;
    }
// By variables

    public String verifyViewPoojaDetailsHeader(){
        return driver.findElement(By.xpath("//div[@id='bar']/h1")).getText();
    }
}
