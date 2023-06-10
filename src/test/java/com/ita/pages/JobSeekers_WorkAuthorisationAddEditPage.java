package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekers_WorkAuthorisationAddEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_WorkAuthorisationAddEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By authorisation = By.id("country");

    public void setWorkAuthorisation(String workEditAuthorisation) {

        driver.findElement(authorisation).sendKeys(workEditAuthorisation);
    }
}


