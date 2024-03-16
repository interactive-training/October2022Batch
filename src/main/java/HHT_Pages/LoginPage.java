package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver){
        //super(driver);
       this.driver = driver;
    }

    By emailIDBy = By.id("usr_email");
    By pwdBy = By.id("usr_password");

    public void getURL(String url){
        driver.get(url);
    }

    public void loginAsAdmin(String emailId, String password) {
        driver.findElement(emailIDBy).sendKeys(emailId); // email Id
        driver.findElement(pwdBy).sendKeys(password);    // password

        //Submit button
        JavascriptExecutor jse = (JavascriptExecutor) driver;// Login Button
        jse.executeScript("document.querySelector(\"input[value='Login']\").click();");
        System.out.println("Login successful");
    }




}
