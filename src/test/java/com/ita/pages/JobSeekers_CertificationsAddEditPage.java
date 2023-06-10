package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_CertificationsAddEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_CertificationsAddEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By editCertificationName = By.id("cname");
    By yearAcquiredCertification = By.id("syear");
    By monthAcquiredCertification = By.name("smonth");
    By editCertificationSummary = By.id("summary");

    // Add Certifications
    public void setAddCertificationName(String addCertificationName) {
        driver.findElement(editCertificationName).sendKeys(addCertificationName);
    }

    public void setAddCertificationSummary(String addCertificationSummary) {
        driver.findElement(editCertificationSummary).sendKeys(addCertificationSummary);
    }

    public void setAddYearAcquiredCertification(String certificateYear) {
        WebElement elmCYear = driver.findElement(yearAcquiredCertification);
        Select selectobj3 = new Select(elmCYear);
        selectobj3.selectByValue(certificateYear);
    }
    public void setAddMonthAcquiredCertification(String certificateMonth) {
        WebElement elmCMonth = driver.findElement(monthAcquiredCertification);
        Select selectobj3 = new Select(elmCMonth);
        selectobj3.selectByValue(certificateMonth);
    }

}

    //  Defect: Edit button isn't working

