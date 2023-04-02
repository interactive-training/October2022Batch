package ITATest.pages;

import ITATest.CommonComponents.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Credentials extends CommonMethods {

    WebDriver driver;

    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");

    By errorMsgLocator = By.xpath("//div[@id='errorval']/b");

    public Credentials(WebDriver paramDriver){
        super(paramDriver);
        this.driver = paramDriver;

    }

    public void login(String email, String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(button).click();


    }


    public String getErrorMsg(){
        return driver.findElement(errorMsgLocator).getText();
    }



}
