package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    public static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    // By variables

    public void clickCheckOut(){
        driver.findElement(By.partialLinkText("Checkout")).click();
        System.out.println("Clicked on Checkout");
    }
    public Boolean verifyCartItemsHeader(){
        return driver.findElement(By.xpath("//h2[text()='Cart Items']")).isDisplayed();
    }

}
