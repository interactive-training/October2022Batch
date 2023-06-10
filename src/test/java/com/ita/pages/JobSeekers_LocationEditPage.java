package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_LocationEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_LocationEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By elmAddress1 = By.name("address1");
    By elmAddress2 = By.id("address2");
    By elmCountry = By.id("country");
    By elmPostcode = By.id("postcode");
    By elmTown = By.id("city");

    // Edit Location
    public void setAddress1(String address1) {
        driver.findElement(elmAddress1).clear();
        driver.findElement(elmAddress1).sendKeys(address1);
    }

    public void setAddress2(String address2) {
        driver.findElement(elmAddress2).clear();
        driver.findElement(elmAddress2).sendKeys(address2);
    }

    public void setCountry(String country) {
        driver.findElement(elmCountry).clear();
        driver.findElement(elmCountry).sendKeys(country);
    }

    public void setPostcode(String postcode) {
        driver.findElement(elmPostcode).clear();
        driver.findElement(elmPostcode).sendKeys(postcode);
    }

    public void setTown(String town) {
        driver.findElement(elmTown).clear();
        driver.findElement(elmTown).sendKeys(town);
    }
}