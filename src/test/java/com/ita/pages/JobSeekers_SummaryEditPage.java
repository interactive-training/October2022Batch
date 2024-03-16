package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_SummaryEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_SummaryEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By editsummary = By.name("summary");

    // Edit Summary Method
    public void setSummary(String summary) {
        driver.findElement(editsummary).clear();
        driver.findElement(editsummary).sendKeys(summary);
    }

}
