package com.ita.pages;
import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobseekersEducationPage extends BasePage {
    WebDriver driver;
    public JobseekersEducationPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    // Other Variables
    By dType = By.id("dtype");
    By dName = By.id("dname");
    By sName = By.id("sname");
    By cName = By.id("country");
    By tName = By.id("town");
    By elmConcentration = By.id("concentration");
    By elmDescription = By.id("description");
    By assertEducationPage = By.xpath("//div[text()='Add Education']");

    // METHODS
    // Click Add Button of Education
    public void setClickAddEducation(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("(document.getElementsByClassName('add_button'))[1].click();");
        //Assert.assertTrue(driver.findElement(assertEducationPage).isDisplayed());
    }

    // Select Degree Type
    public void setDegreeType(String degreeType){
        WebElement elmDT = driver.findElement(dType);
        Select selectobj = new Select(elmDT);
        selectobj.selectByValue(degreeType);
    }

    // Select Degree Name
    public void setDegreeName(String degreeName){
        driver.findElement(dName).sendKeys(degreeName);
    }
    // Select School Name
    public void setSchoolName(String schoolName){
        driver.findElement(sName).sendKeys(schoolName);
    }
    // Select Country Name
    public void setCountryName(String countryName){
        driver.findElement(cName).clear();
        driver.findElement(cName).sendKeys(countryName);
    }
    // Select Country Name
    public void setTownName(String townName){
        driver.findElement(tName).sendKeys(townName);
    }

    // Select dates
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
    public void selectCompletionMonth(String endMonth){
        WebElement elmCompletionMonth = driver.findElement(By.id("emonth")); // locating using css id
        Select selectobj = new Select(elmCompletionMonth);
        selectobj.selectByValue(endMonth);
    }
    public void selectCompletionYear(String endYear){
        WebElement elmCompletionYear = driver.findElement(By.id("eyear")); // locating using css name didn't work
        Select selectobj = new Select(elmCompletionYear);
        selectobj.selectByValue(endYear);
    }

    // Select Concentration
    public void setConcentration(String concentration){
        driver.findElement(elmConcentration).sendKeys(concentration);
    }

    // Select Concentration
    public void setDescription(String description){
        driver.findElement(elmDescription).sendKeys(description);
    }

}
