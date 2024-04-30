package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DonationsProductDetailsPage {
    public static final Logger log = LogManager.getLogger(DonationsProductDetailsPage.class.getName());

    WebDriver driver;
    public DonationsProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    // By variables

    //Page Methods

    public  void clickAddToCartButton(){
        WebElement element = driver.findElement(By.name("submit"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].click();", element);

        System.out.println("Clicked on ADD to Cart link");
    }
    public Boolean verifyProductDetailsHeader(){
        return driver.findElement(By.xpath("//h2[text()='Product Details']")).isDisplayed();
    }
}
