package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_LinkEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_LinkEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By editLinkURL = By.id("url");
    By editDescription = By.id("description");

    //Edit Link Methods
    public void setLinkURL(String url) {
        driver.findElement(editLinkURL).sendKeys(url);
    }

    public void setLinkDescription(String descn) {
        driver.findElement(editDescription).sendKeys(descn);
    }
}
