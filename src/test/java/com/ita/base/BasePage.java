package com.ita.base;

import com.ita.pages.JobSeekersLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    By saveButton = By.id("savechanges");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }
    public String getBrowserUrl(){
        return driver.getCurrentUrl();
    }

    public void waitForElementToAppear(WebElement elmToAppear){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(elmToAppear));
    }

    // save method if it appears in the visible window
    public  void clickSaveButton(){
        driver.findElement(saveButton).click();
    }

    // save method if it does not appear in the visible window
    public void clickSaveChanges(){
        JavascriptExecutor jse =  (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('savechanges').click();");
    }
}
