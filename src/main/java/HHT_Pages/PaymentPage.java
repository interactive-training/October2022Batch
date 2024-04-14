package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }

    public void enterCardDetails(String CardNumber, String ExpiryDetails,String CVC){
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

//       driver.switchTo().alert().getText();
//     WebElement C = driver.findElement(By.id("card_number"));
//        Actions action = new Actions(driver);
//        action.moveToElement(C).sendKeys("4242424242424242");
        WebElement iFrame1 = driver.findElement(By.name("stripe_checkout_app"));
        driver.switchTo().frame(iFrame1);
        //String cardNum= "4242424242424242";
        WebElement inputField= driver.findElement((By.xpath("(//div[@class='cardNumberInput input top'])//input")));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", CardNumber, inputField);
//driver.findElement(By.xpath("(//div[@class='cardNumberInput input top'])//input")).sendKeys("4242424242424242");
//Thread.sleep(6000);
//mywait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//div[@class='cardNumberInput input top'])//input")))).sendKeys("4242 4242 4242 4242");
//     driver.findElement(By.id("cc-exp")).sendKeys("09/25");
        //String cExp= "09/25 ";
        WebElement inputField1= driver.findElement(By.id("cc-exp"));
        JavascriptExecutor js1= (JavascriptExecutor) driver;
        js1.executeScript("arguments[1].value = arguments[0]; ", ExpiryDetails, inputField1);
        driver.findElement(By.id("cc-csc")).sendKeys(CVC);
        driver.findElement(By.xpath("(//div[@class='inner'])[2]")).click();
        driver.switchTo().defaultContent();
        System.out.println("entered the card details and clicked on Pay ");
    }
}
