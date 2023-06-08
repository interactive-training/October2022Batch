package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitersLandingPage extends BasePage {
    static WebDriver driver;
    public RecruitersLandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //By jobsAndApplicationsLink = By.linkText("Jobs & applications");

     By jobsAndApplicationsLink = By.xpath("//a[@href='manage_jobs.php']");

//    public static ManageJobsPage clickJobsAndApplications(){
//        driver.findElement(jobsAndApplicationsLink).click();
//        return new ManageJobsPage(driver);
//    }
    public void clickJobsAndApplications(){
        driver.findElement(jobsAndApplicationsLink).click();
    }

}
