package com.ita.pages;

import com.ita.util.TestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasePage extends  TestContext{

    public static final Logger log = LogManager.getLogger(BasePage.class.getName());

    WebDriver driver;

    public BasePage(WebDriver driver){

        this.driver = driver;

        log.error("Base Page created., The  driver title is: " + driver.getTitle());
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public void waitForElementToAppear(WebElement elmToAppear){
        log.info("Waiting for ");
        //explicit wait
//        WebElement elmToAppear = driver.findElement(elm);
//        Thread.sleep(2000);
        prop.getProperty("ExplicitWait");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(elmToAppear));

    }

    public void saveChangesButton(){

        log.info("Clicking button using javascript");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('savechanges').click();");
    }

}
