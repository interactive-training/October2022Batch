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

    // Click Awards    By.cssSelector(“input[type=\”checkbox\”][data-name=\”sampleChecklist\”]”
    //JavascriptExecutor jse = (JavascriptExecutor) driver;
    //    jse.executeScript("document.getElementById('savechanges').click();");

    public void setAddAwardName(String awardName) {
        By addAwardName = By.xpath("//input[@id='cname']");
        driver.findElement(addAwardName).sendKeys(awardName);
    }

    //Add Award Description
    public void setAddAwardDescription(String awardDescription) {
        By addAwardDescription = By.id("summary");
        driver.findElement(addAwardDescription).sendKeys(awardDescription);
    }

    // Add Extracurriculars
    public void setAddExtracurriculars(String extracurriculars) {
        By addExtracurriculars = By.id("summary-textarea");
        driver.findElement(addExtracurriculars).sendKeys(extracurriculars);
    }
}




