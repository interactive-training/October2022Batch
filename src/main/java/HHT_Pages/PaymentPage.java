package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    public static final Logger log = LogManager.getLogger(PaymentPage.class.getName());
    WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }
    // By variables

    public Boolean verifyPaymentPageHeader(){
        return driver.findElement(By.xpath("(//div[@class='col-md-12'])//h2")).isDisplayed();
    }
    public void clickPayWithCard(){
        driver.findElement(By.xpath("//button[@class='stripe-button-el']")).click();
        System.out.println("Clicked on pay with card");
        log.info("Clicked on pay with card");
    }

    public void enterCardDetails(String CardNumber, String ExpiryDetails,String CVC){
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement iFrame1 = driver.findElement(By.name("stripe_checkout_app"));
        driver.switchTo().frame(iFrame1);
        WebElement inputField= driver.findElement((By.xpath("(//div[@class='cardNumberInput input top'])//input")));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", CardNumber, inputField);
        WebElement inputField1= driver.findElement(By.id("cc-exp"));
        js.executeScript("arguments[1].value = arguments[0]; ", ExpiryDetails, inputField1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("cc-csc"))).sendKeys(CVC);//driver.findElement(By.id("cc-csc")).sendKeys(CVC);
        driver.findElement(By.xpath("(//div[@class='inner'])[2]")).click();
        driver.switchTo().defaultContent();
        System.out.println("entered the card details and clicked on Pay ");
        log.info("Entered the card details and clicked on Pay ");
    }
}
