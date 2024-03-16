package com.ita.pages;
import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobseekersProfileOtherAddButtonsPage extends BasePage {
    WebDriver driver;
    public JobseekersProfileOtherAddButtonsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }




    // Add Extracurriculars
    public void setAddExtracurriculars(String extracurriculars) {
        By addExtracurriculars = By.id("summary-textarea");
        driver.findElement(addExtracurriculars).sendKeys(extracurriculars);
    }

    // Add Work Authorisation
    public void setWorkAuthorisation(String workEditAuthorisation) {
        By authorisation = By.id("country");
        driver.findElement(authorisation).sendKeys(workEditAuthorisation);
    }
}




