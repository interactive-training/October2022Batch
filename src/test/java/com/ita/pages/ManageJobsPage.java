package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageJobsPage extends BasePage {
        static WebDriver driver;
        public ManageJobsPage(WebDriver driver) {
            super(driver);
            this.driver = driver;
        }
        By viewJob = By.xpath("//div[text()='Job View']");  // for verifying the Job View Header;//not used
        By editJob = By.xpath("//div[text()='Job Editing']");  // for verifying the Job Editing Header;//not used
        By manageJobsTextBy = By.xpath("//div[text()='Manage Jobs ']");
        int n; // for exiting the loops of rows and columns
        String elementValue;

    public int getRecord(String record, String option) throws InterruptedException {
            // Storing all the rows in rowElements and  printing its size
            List<WebElement> rowElements = driver.findElements(By.xpath("//table/tbody/tr"));
            System.out.println(rowElements.size());

            //Storing all the columns in columnElements and  printing its size
            List<WebElement> columnElements = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
            System.out.println(columnElements.size());

            // iterating the rows and columns for each element - tr1: td1,td2...td7; tr2:td1,td2...etc
            for (int r = 1; r <= rowElements.size(); r++) {
                for (int c = 1; c <= columnElements.size(); c++) {
                    elementValue = driver.findElement(By.xpath("//table/tbody/tr[" + r + "]/td[" + c + "]")).getText();
                    if (record.equalsIgnoreCase(elementValue) && option.equalsIgnoreCase("delete")) {
                        driver.findElement(By.xpath("//table/tbody/tr[" + r + "]/td[7]/a[text()='Delete ']")).click();
                        System.out.println(" Record deleted.");
                        n = 1;

                    } else if (record.equalsIgnoreCase(elementValue) && option.equalsIgnoreCase("edit")) {
                        driver.findElement(By.xpath("//table/tbody/tr[" + r + "]/td[7]/a[text()=' Edit']")).click();
                        driver.findElement(By.name("jobdescription")).clear();
                        driver.findElement(By.name("jobdescription")).sendKeys("We need atleast 2 years of Automation Testing experience.");
                        System.out.println(" Record edited.");
                        n = 2;
                        Thread.sleep(3000);
                    } else if (record.equalsIgnoreCase(elementValue) && option.equalsIgnoreCase("view")) {
                        driver.findElement(By.xpath("//table/tbody/tr[" + r + "]/td[7]/a[text()=' View']")).click();
                        System.out.println(" Record viewed.");
                        n = 3;
                        Thread.sleep(3000);
                    }

                    if (n == 1 || n==2 ||n==3 ) {
                        break;
                    } // in order to break from the loop of columns(as n=0 until it enters any if condition)
                }
                if (n == 1 || n==2 ||n==3) {
                    break;
                }// in order to break from the loop of rows; also for edit(n=2) and view(n=3) verification)
            }
            if (n == 0) {
                System.out.println(" Record not found.");} // for delete verification
            return n;
    }

    public String getJobEdit(){  //not used
        return driver.findElement(editJob).getText();
    }

    public String getJobView(){  //not used
        return driver.findElement(viewJob).getText();
    }

// Verify Page Header
    public String manageJobsHeader(){
        return driver.findElement(manageJobsTextBy).getText();
    }



    public static void clickJobsAndApplications(){
        By jobsAndApplicationsLink = By.xpath("//a[@href='manage_jobs.php']");
        driver.findElement(jobsAndApplicationsLink).click();
    }



}
