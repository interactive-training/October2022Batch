package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class MyAccountPage {
    public static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());
    WebDriver driver;
    // Constructor
    public MyAccountPage(WebDriver driver){
        //super(driver);
        this.driver = driver;
    }
// By variables

    public Boolean verifyMyAccountHeader(){
        return  driver.findElement(By.xpath("//h1[text()='My Account']")).isDisplayed();
    }

    public void loginAsRegisteredUser(String UserName, String Password){
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(UserName);
        driver.findElement(By.id("pwd")).sendKeys(Password);
        //click button
        WebElement element = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
