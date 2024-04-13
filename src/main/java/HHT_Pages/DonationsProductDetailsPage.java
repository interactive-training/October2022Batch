package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DonationsProductDetailsPage {
    public static final Logger log = LogManager.getLogger(DonationsProductDetailsPage.class.getName());

    WebDriver driver;
    public DonationsProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    // By variables

    //Page Methods

    public  void clickAddToCartButton(){
        driver.findElement(By.name("submit")).click();
        System.out.println("Clicked on ADD to Cart link");
    }
}
