package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ManageJobsEditPage extends BasePage {
    WebDriver driver;
    public ManageJobsEditPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    By jobTitleBy = By.name("Jobtitle");
    By editLocationBy = By.id("country");
    By specificLocationBy = By.name("specificlocation");
    By editDateBy = By.id("day");
    By editMonthBy = By.id("month");
    By editYearBy = By.id("year");
    By editSectorBy = By.name("sector");
    By jobDescriptionBy = By.name("jobdescription");
    By clickSubmitButtonBy = By.name("next");

    public void editJobTitle(String jobTitle){
        driver.findElement(jobTitleBy).clear();
        driver.findElement(jobTitleBy).sendKeys(jobTitle);
    }
    public void editLocation(String location){
        WebElement elmToSelect = driver.findElement(editLocationBy);
        Select selectObj = new Select(elmToSelect);
        selectObj.selectByVisibleText(location);
    }

    public void editSpecificLocation(String location){
        driver.findElement(specificLocationBy).clear();
        driver.findElement(specificLocationBy).sendKeys(location);
    }

    public void editDay(String day){
        WebElement elmToSelect = driver.findElement(editDateBy);
        Select selectObj = new Select(elmToSelect);
        selectObj.selectByValue(day);
    }

    public void editMonth(String month){
        WebElement elmToSelect = driver.findElement(editMonthBy);
        Select selectObj = new Select(elmToSelect);
        selectObj.selectByValue(month);
    }

    public void editYear(String year){
        WebElement elmToSelect = driver.findElement(editYearBy);
        Select selectObj = new Select(elmToSelect);
        selectObj.selectByValue(year);
    }

    public void editSector(String sector){
        WebElement elmToSelect = driver.findElement(editSectorBy);
        Select selectObj = new Select(elmToSelect);
        selectObj.selectByVisibleText(sector);
    }
    public void editJobDescription(String jobDescription){
        driver.findElement(jobDescriptionBy). clear();
        driver.findElement(jobDescriptionBy).sendKeys(jobDescription);
    }
    public void clickSubmit(){
        driver.findElement(clickSubmitButtonBy).click();
    }




}
