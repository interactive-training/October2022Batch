package com.ita.pages;

import com.ita.util.TestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class WorkExperiencePage extends BasePage{

    public static final Logger log = LogManager.getLogger(WorkExperiencePage.class.getName());

    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");
    By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");

    TestContext testContext;
    WebDriver driver;

    public WorkExperiencePage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }


    public void addCompanyName( String name){
        By companyName = By.id("comp");
        driver.findElement(companyName).sendKeys(name);
    }

    public void addJobTitle(String title){

        By jobTitle = By.cssSelector("input[name = jtitle]");
        driver.findElement(jobTitle).sendKeys(title);
    }

    public void modifyCountry(String country) {
        By countryName = By.name("country");
        driver.findElement(countryName).clear();
        driver.findElement(countryName).sendKeys(country);
   //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void checkBoxUpdateHeadline(){
        By headline = By.name("upd_jtitle");
        driver.findElement(headline).click();
    }

    public void selectJobType(String jobType){
        WebElement elmjobType = driver.findElement(By.xpath("//div/select[@id='jtype']"));
        Select selectObj = new Select(elmjobType);
        selectObj.selectByValue(jobType);
    }
    public void selectStartMonth(String startMonth){
        WebElement elmstartMonth = driver.findElement(By.id("smonth"));
        Select selectObj = new Select(elmstartMonth);
        selectObj.selectByValue(startMonth);
    }
    public void selectStartYear(String startYear){
        WebElement elmStartYear = driver.findElement(By.name("syear"));
        Select selectobj = new Select(elmStartYear);
        selectobj.selectByValue(startYear);
    }
    public void selectEndMonth(String endMonth){
        WebElement elmEndMonth = driver.findElement(By.cssSelector("#emonth")); // locating using css id
        Select selectobj = new Select(elmEndMonth);
        selectobj.selectByValue(endMonth);
    }
    public void selectEndYear(String endYear){
        WebElement elmEndYear = driver.findElement(By.id("eyear")); // locating using css name didn't work
        Select selectobj = new Select(elmEndYear);
        selectobj.selectByValue(endYear);
    }

    public void addachievement(String achievements){
        By addachievements = By.id("achievements");
        driver.findElement(addachievements).sendKeys(achievements);
    }

    public void addDescription(String description){
        By addDescription = By.name("description");
        driver.findElement(addDescription).sendKeys(description);
    }

    public Boolean ifChecked(){

        WebElement chk = driver.findElement(By.name("upd_jtitle"));
//        chk // homeowrk - heck value for 1 or 0 , 1 - cheked, 0-unchecked

        return false;
    }

    public Boolean isJobTitleExistByName(String expectedjobTitle){

        By jobTitleBy = By.xpath("//strong[text()='" + expectedjobTitle + "']");

        WebElement elm = driver.findElement(jobTitleBy);

        return elm.isDisplayed();
    }


}
