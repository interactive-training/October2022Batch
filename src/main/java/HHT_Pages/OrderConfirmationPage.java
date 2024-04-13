package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    public static final Logger log = LogManager.getLogger(OrderConfirmationPage.class.getName());
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver;
    }
    // By variables

    public String verifyOrderConfirmationHeader(){
        return driver.findElement(By.xpath("(((//div[@class='body-inner'])//div)[17])//h2")).getText();
    }

}
