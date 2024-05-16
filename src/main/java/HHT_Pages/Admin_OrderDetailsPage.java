package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Admin_OrderDetailsPage {
    public static final Logger log = LogManager.getLogger(News_AddNewsDetailsPage.class.getName());
    WebDriver driver;
    By OrdersDetailsHeaderBy = (By.xpath("//h1[text()='All Orders']"));

    public Admin_OrderDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean verifyOrdersDetailsHeader(){
        return driver.findElement(OrdersDetailsHeaderBy).isDisplayed();
    }

}
