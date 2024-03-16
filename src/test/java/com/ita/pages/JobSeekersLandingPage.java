package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobSeekersLandingPage extends BasePage {
     WebDriver driver;
     By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");
     By locationBy = By.xpath("//a[@href='location.php']/img");
     By contactBy = By.xpath("//a[@href='contact_information.php']/img");
     By workButton = By.xpath("//h1[text()='Work Experience ']/..//a/button");
     By clickSummary = By.xpath("//a[@href='summary.php']/img");
     By clickLink = By.xpath("//a[@href='links.php']/button"); //h1[text()='Links ']/../div/a/img")
     By clickSkills = By.xpath("//a[@href='skills.php']/img");
     By clickEditWorkAuthorisation = By.xpath("(//a[@href='work_authorisation.php'])[2]/img");
     By clickAddWorkAuthorisation = By.xpath("(//a[@href='work_authorisation.php'])[1]/button");
     By clickLanguages = By.xpath("//a[@href='languages.php']/img");
     By clickAddCertifications = By.xpath("//a[@href='certifications.php']/button");

    //verification locators on Jobseekers Landing Page
    By myProfileHeaderDisplayedBy = By.xpath("//div[@class='myprofile']");
    By summaryDisplayedBy = By.xpath("//div/h1[text()='Summary  ']/../div/p");
    By linkUrlDisplayedBy = By.xpath("//a[@class='lin']"); // //div[@class='summary'][1]/following-sibling::*/p
    By skillsDisplayedBy = By.xpath("//div[@class='skils_p']/p[1]");
    By skillsLevelDisplayedBy = By.xpath("//div[@class='skils_p']/p[2]");
    By workAuthorisationDisplayedBy = By.xpath("//h1[text()='Work Authorisation ']/..//ul/li/strong");
    By languageDisplayedBy = By.xpath("(//p[@class='skils_p_left'])[2]");
    By languageRelevanceDisplayedBy = By.xpath("(//p[@class='skils_p_right'])[2]");
    By awardsDisplayedBy = By.xpath("//div[@class='summary'][9]/following-sibling::*/p/strong");
    int n;
    public JobSeekersLandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Click on Work Experience
    public  JobseekersWorkExperiencePage clickAddWorkExperience(){
        driver.findElement(workButton).click();
        return new JobseekersWorkExperiencePage(driver);
    }
    // Click Add Button of Education
    public  JobseekersEducationPage clickAddEducation(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("(document.getElementsByClassName('add_button'))[2].click();");
        //Assert.assertTrue(driver.findElement(assertEducationPage).isDisplayed());
        return new JobseekersEducationPage(driver);
    }

    // Click Contact Information Icon
    public  JobSeekers_ContactInformationEditPage clickContact(){
        driver.findElement(contactBy).click();
        //log.info("Contact Icon is clicked.");
        return new JobSeekers_ContactInformationEditPage(driver);
    }

    // Click Location
    public  JobSeekers_LocationEditPage clickLocation(){
        driver.findElement(locationBy).click();
        return new JobSeekers_LocationEditPage(driver);
    }
    // Click Summary Icon
    public  JobSeekers_SummaryEditPage clickSummary() {
        driver.findElement(clickSummary).click();
        return new JobSeekers_SummaryEditPage(driver);
    }
    // Click Link Method
    public  JobSeekers_LinkEditPage clickLink() {
        driver.findElement(clickLink).click();
        return new JobSeekers_LinkEditPage(driver);
    }
    // Click Skills Method
    public  JobSeekers_SkillsEditPage clickSkills() {
        driver.findElement(clickSkills).click();
        return new JobSeekers_SkillsEditPage(driver);
    }

    // Click Work Authorisation Edit icon
    public JobSeekers_WorkAuthorisationAddEditPage clickWorkAuthorisationEdit() {
        driver.findElement(clickEditWorkAuthorisation).click();
        return new JobSeekers_WorkAuthorisationAddEditPage(driver);
    }

    // Click Work Authorisation Add button
    public  JobSeekers_WorkAuthorisationAddEditPage clickWorkAuthorisationAdd() {
        driver.findElement(clickAddWorkAuthorisation).click();
        return new JobSeekers_WorkAuthorisationAddEditPage(driver);
    }

    // Click Languages Edit Icon
    public JobSeekers_LanguagesEditPage clickLanguages() {
        driver.findElement(clickLanguages).click();
        return new JobSeekers_LanguagesEditPage(driver);
    }

    //Click Add Certifications Button
    public JobSeekers_CertificationsAddEditPage clickCertificationsAdd() {
        driver.findElement(clickAddCertifications).click();
        return new JobSeekers_CertificationsAddEditPage(driver);
    }
    //Click Add Awards Button
    public JobSeekers_AwardsAddEditPage clickAddAwards() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("(document.getElementsByClassName('add_button'))[4].click();");
        return new JobSeekers_AwardsAddEditPage(driver);
    }

    //Click Extracurriculars
    public Jobseekers_ExtracurricularsAddPage clickAddExtracurriculars() {
        JavascriptExecutor jsce = (JavascriptExecutor) driver;
        jsce.executeScript("(document.getElementsByClassName('add_button'))[5].click();");
        return new Jobseekers_ExtracurricularsAddPage(driver);
    }

    // Click Additional Information-Relocate Edit Icon
    public JobSeekers_RelocateEditPage setClickRelocate() {
        By addRelocate = By.xpath("//a[@href='willingness_to_relocate.php']/img");
        driver.findElement(addRelocate).click();
        return new JobSeekers_RelocateEditPage(driver);
    }

    // Click Additional Information-Travel
    public JobSeekers_TravelEditPage setClickTravel() {
        By addTravel = By.xpath("//a[@href='willingness_to_travel.php']/img");
        driver.findElement(addTravel).click();
        return new JobSeekers_TravelEditPage(driver);
    }

    // Verifications
    public  boolean isWorkExperienceHeaderTextDisplayed(){
        return driver.findElement(workExperienceHeaderBy).isDisplayed();
    }
    public boolean isMyProfileHeaderTextDisplayed(){
        return driver.findElement(myProfileHeaderDisplayedBy).isDisplayed();
    }

    public  String verifySummaryText(){
        return driver.findElement(summaryDisplayedBy).getText();
    }
    public String verifyLinkUrl(){return driver.findElement(linkUrlDisplayedBy).getText();}
    public String verifySkill(){return driver.findElement(skillsDisplayedBy).getText();}
    public String verifySkillLevel(){return driver.findElement(skillsLevelDisplayedBy).getText();}
    public String verifylanguage(){return driver.findElement(languageDisplayedBy).getText();}
    public String verifyLanguageRelevanceType(){return driver.findElement(languageRelevanceDisplayedBy).getText();}
    public String verifyWorkAuthorisation(){return driver.findElement(workAuthorisationDisplayedBy).getText();}
    public String verifyAwards(){return driver.findElement(awardsDisplayedBy).getText();}

    public boolean verifyLatestfieldText(String fieldValue){
        List<WebElement> fieldList = driver.findElements(By.xpath("//div[@class='get']/p/strong"));
        System.out.println(fieldList.size());

        for (int r = 1; r <= fieldList.size(); r++) {
            WebElement elm = fieldList.get(r);
            String fieldText = elm.getText();   //driver.findElement(By.xpath("//div[@class='texticon']/../p/strong")).getText();
            if (fieldValue.equalsIgnoreCase(fieldText)) {
                System.out.println("The record is added.");
                 n=1;
                break;
            }
        }
        if (n==1)
        return true;
        else return false;
    }

    // verify Contact record through phone number
    public String getPhoneNumber() {
        String actualPhone = driver.findElement(By.xpath("//h1[text()='Contact Information']/..//p/text()[3]")).getText();
        //log.info("Phone number is retrieved from the Profile Page.");
        return actualPhone;
    }
    public boolean verifyContactInformationText(String fieldValue){
        List<WebElement> fieldList = driver.findElements(By.xpath("h1[text()='Contact Information']/..//p/text()")); ///html/body/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/p/text()[3]
        System.out.println(fieldList.size());

        for (int r = 1; r <= fieldList.size(); r++) {
            WebElement elm = fieldList.get(r);
            String fieldText = elm.getText();
            if (fieldValue.equalsIgnoreCase(fieldText)) {
                System.out.println("The information is up-to-date.");
                n=1;
                break;
            }
        }
        if (n==1)
            return true;
        else return false;
    }
    public boolean verifySkillsLanguagesText(String fieldValue){
        List<WebElement> fieldList = driver.findElements(By.xpath("(//p[@class='skils_p_left'])"));
        System.out.println(fieldList.size());

        for (int r = 1; r <= fieldList.size(); r++) {
            WebElement elm = fieldList.get(r);
            String fieldText = elm.getText();
            if (fieldValue.equalsIgnoreCase(fieldText)) {
                System.out.println("The information is up-to-date.");
                n=1;
                break;
            }
        }
        if (n==1)
            return true;
        else return false;
    }
    //
}
//By linkDescriptionDisplayedBy = By.xpath();//"//a[@class='lin']/../br"
//public String verifyLinkDescription(){return driver.findElement(linkDescriptionDisplayedBy).getText();}
//By clickEditCertifications = By.xpath("//a[@href='edit_cert.php']/img");
//public String verifyEducation(){return driver.findElement(educationSchoolNameDisplayedBy).getText();}
//public String verifyWorkExperience(){return driver.findElement(workExperienceTitleDisplayedBy).getText();}

//By workExperienceTitleDisplayedBy = By.xpath("//div[@class='summary'][4]/following-sibling::*/p/strong");
//By educationSchoolNameDisplayedBy = By.xpath("//div[@class='summary'][5]/following-sibling::*/p/strong");
//By certificationLanguageDisplayedBy = By.xpath("//div[@class='summary'][6]/following-sibling::*/p/strong");
//div[@class='summary']/following-sibling::*/p

//    By clickAddExtracurriculars = By.xpath("//h1[text()='Extracurriculars ']//../div/a/button");
//    driver.findElement(clickAddExtracurriculars);}
