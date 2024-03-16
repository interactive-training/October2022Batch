package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    Properties prop;

    // Constructor
    public LoginPage(WebDriver driver){
        //super(driver);
       this.driver = driver;
    }
// By variables
    By emailIDBy = By.id("usr_email");
    By pwdBy = By.id("usr_password");

// Page methods

    public void getAdminURL(String admin) throws IOException {
        // Reading Properties file and get admin url
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
        prop.load(fis);
        String adminURL = prop.getProperty("AdminURL");
        driver.get(adminURL);
    }

    public void loginAsAdmin(String emailId, String password) {
        driver.findElement(emailIDBy).sendKeys(emailId); // email Id
        driver.findElement(pwdBy).sendKeys(password);    // password

        //Submit button
        JavascriptExecutor jse = (JavascriptExecutor) driver;// Login Button
        jse.executeScript("document.querySelector(\"input[value='Login']\").click();");
        System.out.println("Login successful");
    }

    public void getWebsiteURL() throws IOException {
        // Reading Properties file and get the url
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
        prop.load(fis);

        driver.get(prop.getProperty("WebsiteURl"));

    }






}
