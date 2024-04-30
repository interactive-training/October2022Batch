package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonMethods {
    public static final Logger log = LogManager.getLogger(CalendarPage.class.getName());
    WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    //By variables
    // click Submit button
    public void clickSubmitButton(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;// Login Button
        jse.executeScript("document.querySelector(\"input[value='Submit']\").click();");
        System.out.println("Clicked Submit");
    }

    // verify message
    public String verifyMessage(){return driver.findElement(By.xpath("//div[@class='error_msg']")).getText();}
}
