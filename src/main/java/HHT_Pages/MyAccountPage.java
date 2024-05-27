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

public class MyAccountPage {
    public static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());
    WebDriver driver;
    // Constructor
    public MyAccountPage(WebDriver driver){
        //super(driver);
        this.driver = driver;
    }
    // By variables
    By MyAccountHeaderBy = By.xpath("//a[@class='btn btn-primary']");

    public Boolean verifyMyAccountHeader(){
        return  driver.findElement(By.xpath("//h1[text()='My Account']")).isDisplayed();
    }
    public void clicksMyAccount(){
        WebElement myAcct = driver.findElement(MyAccountHeaderBy);
        myAcct.click();
    }
    public void loginAsRegisteredUser(String UserName, String Password){
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(UserName);
        driver.findElement(By.id("pwd")).sendKeys(Password);
        //click button
//        WebDriverWait wait = new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-primary'])[1]")));//driver.findElement();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebElement element = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].click();", element);
        System.out.println("Login button clicked");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }
}
