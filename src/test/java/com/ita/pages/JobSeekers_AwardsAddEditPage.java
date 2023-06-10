package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekers_AwardsAddEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_AwardsAddEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    // Click Awards    By.cssSelector(“input[type=\”checkbox\”][data-name=\”sampleChecklist\”]”
    //JavascriptExecutor jse = (JavascriptExecutor) driver;
    //    jse.executeScript("document.getElementById('savechanges').click();");

    public void setAwardName(String awardName) {
        By addAwardName = By.xpath("//input[@id='cname']");
        driver.findElement(addAwardName).sendKeys(awardName);
    }

    //Add Award Description
    public void setAwardDescription(String awardDescription) {
        By addAwardDescription = By.id("summary");
        driver.findElement(addAwardDescription).sendKeys(awardDescription);
    }
}

    // defect

