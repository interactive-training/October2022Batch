package com.ita.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class JobsAndApplicationsPage extends BasePage {

    public static final Logger log = LogManager.getLogger(JobsAndApplicationsPage.class.getName());

    WebDriver driver;

    public JobsAndApplicationsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //========================= Jobs and Applications =====================
    //jobs and verification link
    //verify manager's page appearing



}
