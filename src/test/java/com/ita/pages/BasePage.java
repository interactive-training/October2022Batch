package com.ita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public void waitForElementToAppear(WebElement elmToAppear){

        //explicit wait
//        WebElement elmToAppear = driver.findElement(elm);
//        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong("10"))); //selenium 4
        WebDriverWait wait = new WebDriverWait(driver,10); //selenium  3

        wait.until(ExpectedConditions.visibilityOf(elmToAppear));

    }


}
