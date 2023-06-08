package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class JobseekersWorkExperiencePage extends BasePage {

    WebDriver driver;

    public JobseekersWorkExperiencePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

        //enter company name
        public void setCompanyName(String compName){
            driver.findElement(By.xpath("//input[@id='comp']")).sendKeys(compName);
        }

        //enter job title
        public void setJobTitle(String jobtitle){
            driver.findElement(By.xpath("//input[@id='jtitle']")).sendKeys(jobtitle);
        }
        public void modifyCountry(String country) throws InterruptedException {
            By countryName = By.name("country");
            driver.findElement(countryName).clear();
            driver.findElement(countryName).sendKeys(country);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

        public void updateHeadline(String checkAndUncheck){

            if (checkAndUncheck.equalsIgnoreCase("check")){
                driver.findElement(By.xpath("//input[@name='upd_jtitle']")).click();
            }
            else{
                System.out.println("test");  //do not do anything
            }
        }

        public void setJobType(String jobType){

            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='jtype']"));
            Select selectObj = new Select(elmToSelect);
            selectObj.selectByVisibleText(jobType);

        }


        public void setStartMonth(String startMonth){

            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='smonth']"));
            Select selectObj = new Select(elmToSelect);
            selectObj.selectByValue(startMonth);

        }

        public void setStartYear(String startYear){
            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='syear']"));
            Select selectObj = new Select(elmToSelect);
            selectObj.selectByValue(startYear);
        }
        public void setEndMonth(String endMonth){
            WebElement elmEndMonth = driver.findElement(By.cssSelector("#emonth")); // locating using css id
            Select selectobj = new Select(elmEndMonth);
            selectobj.selectByValue(endMonth);
        }
        public void setEndYear(String endYear){
            WebElement elmEndYear = driver.findElement(By.id("eyear")); // locating using css name didn't work
            Select selectobj = new Select(elmEndYear);
            selectobj.selectByValue(endYear);
        }
        public void addachievement(String achievements){
            By addachievements = By.id("achievements");
            driver.findElement(addachievements).sendKeys(achievements);
        }

        public void setDescription(String desc){
            driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(desc);
        }
//    public String verifyJobTitle(){
//
//        By jobTitleBy = By.xpath("//div[@class='texticon']/../p");
//        String verifyJobTitle = String.valueOf(driver.findElement(jobTitleBy));
//        return verifyJobTitle;
//    }

    ////div[@class='texticon']/../p[1]





}
