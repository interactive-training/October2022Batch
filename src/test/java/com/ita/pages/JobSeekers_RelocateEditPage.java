package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekers_RelocateEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_RelocateEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By relocate = By.id("exampleRadios2");

    public void setRelocate() {

        driver.findElement(relocate).click();
    }
}

