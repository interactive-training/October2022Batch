package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsAndApplicationsPage extends BasePage {

    WebDriver driver;
    By jobsAndApplicationsLink = By.linkText("Jobs & applications");
    By manageJobsTextBy = By.xpath("//div[text()='Manage Jobs ']");

    public JobsAndApplicationsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //========================= Jobs and Applications =====================
    //jobs and verification link
    //verify manager's page appearing



}
