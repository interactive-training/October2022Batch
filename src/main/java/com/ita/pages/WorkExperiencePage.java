package com.ita.pages;

import com.ita.utility.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.Select;

public class WorkExperiencePage extends BasePage {

    WebDriver driver;

    public WorkExperiencePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }




    /*

       // we.AddNew(); // click ADD button

    //we.AddValidExperience(); // default values will be added / all mandatroy fields -- happy flow, click 'save changes'

    //we.enterCompanyName(compname)

    //we.enterJobtitle(sadfas)

    we.CheckUpdaetMyHeadline()
    we.UncheckUpdateHeadLine()



        we.enterCountry()

     */


    //enter company name
        public void enterCompanyName(String compName){

            driver.findElement(By.xpath("//input[@id='comp']")).sendKeys(compName);

        }


        //enter job title
        public void enterJobTitle(String jobtitle){

            driver.findElement(By.xpath("//input[@id='jtitle']")).sendKeys(jobtitle);
        }


        public void updateHeadline(String checkAndUncheck){

            if (checkAndUncheck.equalsIgnoreCase("check")){
                driver.findElement(By.xpath("//input[@name='upd_jtitle']")).click();

            }
            else{
                System.out.println("test");
                //do not do anything
            }

        }

        public void selectJobType(String jobType){

            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='jtype']"));
            Select selectObj = new Select(elmToSelect);
            selectObj.selectByVisibleText(jobType);

        }


        public void selectStartMonth(String stratMonth){

            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='smonth']"));
            Select selectObj = new Select(elmToSelect);
            selectObj.selectByValue(stratMonth);

        }

        public void selectStartYear(String startYear){
            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='syear']"));
            Select selectObj = new Select(elmToSelect);
            selectObj.selectByValue(startYear);

        }

//        selectEndMonth("02");
//        selectEndMonth("2014");

        public void enterDescription(String desc){
            driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(desc);
        }

        public void clickSaveChanges(){

            driver.findElement(By.xpath("//input[@id='savechanges']")).click();

            //work arounds
            //srol dow using javascript exector
            JavascriptExecutor  jse =  (JavascriptExecutor) driver;
            jse.executeScript("document.getElementById('savechanges').click();");


        }



}
