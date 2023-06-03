package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JobSeekersPage extends BasePage {
    static WebDriver driver;
    static By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");
    static By locationBy = By.xpath("//a[@href='location.php']/img");
    static By contactBy = By.xpath("//a[@href='contact_information.php']/img");

    static By workButton = By.xpath("//h1[text()='Work Experience ']/..//a/button");
    static By clickSummary = By.xpath("//a[@href='summary.php']/img");
    static By clickLink = By.xpath("//a[@href='links.php']/img");
    static By clickSkills = By.xpath("//a[@href='skills.php']/img");
    static By clickEditWorkAuthorisation = By.xpath("(//a[@href='work_authorisation.php'])[2]/img");
    static By clickAddWorkAuthorisation = By.xpath("(//a[@href='work_authorisation.php'])[1]/button");
    static By clickLanguages = By.xpath("//a[@href='languages.php']/img");
    static By clickAddCertifications = By.xpath("//a[@href='certifications.php']/button");

    //By clickEditCertifications = By.xpath("//a[@href='edit_cert.php']/img");

    public JobSeekersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    By errorMsgLocator = By.xpath("//div[@id='errorval']/b");

    public String getErrorMsg(){
        return driver.findElement(errorMsgLocator).getText();
    }


    public static JobseekersWorkExperiencePage clickAddWorkExperience(){
        //click on work experience
        driver.findElement(workButton).click();
        return new JobseekersWorkExperiencePage(driver);
    }
    // Click Add Button of Education
    public static JobseekersEducationPage clickAddEducation(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("(document.getElementsByClassName('add_button'))[1].click();");
        //Assert.assertTrue(driver.findElement(assertEducationPage).isDisplayed());
        return new JobseekersEducationPage(driver);
    } // without return also it worked as we are passing driver in the test page? but is it correct?

    // Click Contact Information Icon
    public static JobSeekersProfileEditIconsPage clickContact(){
        driver.findElement(contactBy).click();
        //log.info("Contact Icon is clicked.");
        return new JobSeekersProfileEditIconsPage(driver);
    }

    // Click Location
    public static JobSeekersProfileEditIconsPage clickLocation(){
        driver.findElement(locationBy).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }
    // Click Summary Icon
    public static JobSeekersProfileEditIconsPage clickSummary() {
        driver.findElement(clickSummary).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }
    // Click Link Method
    public static JobSeekersProfileEditIconsPage clickLink() {
        driver.findElement(clickLink).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }
    // Click Skills Method
    public static JobSeekersProfileEditIconsPage clickSkills() {
        driver.findElement(clickSkills).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }

    // Click Work Authorisation Edit icon
    public static JobSeekersProfileEditIconsPage clickWorkAuthorisationEdit() {
        driver.findElement(clickEditWorkAuthorisation).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }

    // Click Work Authorisation Add button
    public static void clickAddWorkAuthorisation() {
        driver.findElement(clickAddWorkAuthorisation).click();
    }

    // Click Languages Edit Icon
    public static JobSeekersProfileEditIconsPage clickLanguages() {
        driver.findElement(clickLanguages).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }

    //Click Add Certifications Button
    public static JobSeekersProfileEditIconsPage setClickAddCertifications() {
        driver.findElement(clickAddCertifications).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }

    public static JobSeekersProfileEditIconsPage setClickAddAwards() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("(document.getElementsByClassName('add_button'))[4].click();");
        return new JobSeekersProfileEditIconsPage(driver);
    }

    //Click Extracurriculars
    public static JobSeekersProfileEditIconsPage setClickAddExtracurriculars() {
        JavascriptExecutor jsce = (JavascriptExecutor) driver;
        jsce.executeScript("(document.getElementsByClassName('add_button'))[5].click();");
        return new JobSeekersProfileEditIconsPage(driver);
    }
//    By clickAddExtracurriculars = By.xpath("//h1[text()='Extracurriculars ']//../div/a/button");
//    driver.findElement(clickAddExtracurriculars);}

    // Click Additional Information-Relocate
    public static JobSeekersProfileEditIconsPage setClickRelocate() {
        By addRelocate = By.xpath("//a[@href='willingness_to_relocate.php']/img");
        driver.findElement(addRelocate).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }

    // Click Additional Information-Travel
    public static JobSeekersProfileEditIconsPage setClickTravel() {
        By addTravel = By.xpath("//a[@href='willingness_to_travel.php']/img");
        driver.findElement(addTravel).click();
        return new JobSeekersProfileEditIconsPage(driver);
    }



    public static boolean isWorkExperienceHeaderTextDisplayed(){
        return driver.findElement(workExperienceHeaderBy).isDisplayed();

    }

}
