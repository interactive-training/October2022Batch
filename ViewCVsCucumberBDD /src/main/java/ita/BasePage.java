package ita;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    // Creating a constructor to connect the drivers
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public String getBrowserUrl(){
        return driver.getCurrentUrl();
    }

    //Save button is common for all the pages
    public void saveChangesButton(){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('savechanges').click();");
    }

//    public void waitForElementToAppear(){
//        WebElement (elmToAppear){
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//            wait.until(ExpectedConditions.visibilityOf(elmToAppear));
//        }


}
