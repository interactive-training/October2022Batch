package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DonationsDetailsPage {
    public static final Logger log = LogManager.getLogger(DonationsDetailsPage.class.getName());

    WebDriver driver;
    public DonationsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    // By variables

    //Page Methods
    public Boolean verifyDonationDetailsHeader(){
        return driver.findElement(By.xpath("//h2[text()='Donation Details']")).isDisplayed();
    }
    public void clickAddToCartButton(){
        driver.findElement(By.linkText("ADD TO CART")).click();

    }

}
