package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_ContactInformationEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_ContactInformationEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By elmNameBy = By.id("fname");
    By elmEmailBy = By.id("email");
    By elmPhoneNumberBy = By.id("mobile");
    By elmPhoneTypeBY = By.id("phonetype");

    // Edit Contact Information
    public void setName(String editName) {
        driver.findElement(elmNameBy).clear();
        driver.findElement(elmNameBy).sendKeys(editName);
        //log.info("Name is edited.");
    }

    // email is not editable : negative test
    public void setEmail(String editEmail) {
        driver.findElement(elmEmailBy).clear();
        driver.findElement(elmEmailBy).sendKeys(editEmail);
        //log.info("Email address is edited.");
    }

    public void setPhone(String editPhoneNumber) {
        driver.findElement(elmPhoneNumberBy).clear();
        driver.findElement(elmPhoneNumberBy).sendKeys(editPhoneNumber);
        //log.info("Phone number is edited.");
    }

    public void setPhoneType(String phoneType) {
        WebElement elmPhoneType = driver.findElement(elmPhoneTypeBY);
        Select selectObj = new Select(elmPhoneType);
        selectObj.selectByValue(phoneType);
    }

    // verify Contact record through phone number
    public String getPhoneNumber() {
        String actualPhone = driver.findElement(By.xpath("//h1[text()='Contact Information']/../p/br[2]")).getText();
        //log.info("Phone number is retrieved from the Profile Page.");
        return actualPhone;
    }
}
