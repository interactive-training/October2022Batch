package com.ita.pages;
import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jobseekers_ExtracurricularsAddPage extends BasePage {
    WebDriver driver;
    public Jobseekers_ExtracurricularsAddPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    By addExtracurriculars = By.id("summary-textarea");

    // Add Extracurriculars
    public void setAddExtracurriculars(String extracurriculars) {
        driver.findElement(addExtracurriculars).sendKeys(extracurriculars);
    }
   // defect :save button isn't working
}




