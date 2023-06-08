package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekersProfileEditIconsPage extends BasePage {
    WebDriver driver;
    public JobSeekersProfileEditIconsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    By elmPhone = By.id("mobile");
    By elmAddress1 = By.name("address1");
    By elmAddress2 = By.id("address2");
    By elmCountry = By.id("country");
    By elmPostcode = By.id("postcode");
    By elmTown = By.id("city");
    By enterSkill = By.id("skills");
    By selectSkillType = By.id("skilltype");
    By editsummary = By.name("summary");
    // Assertions
    By assertSummaryPage = By.xpath("//div/h1[text()='Summary  ']/../div/p");
    By editLinkURL = By.id("url");
    By editDescription = By.id("description");
    By authorisation = By.id("country");
    By editLanguage = By.xpath("//select[@id='lang']");
    By editlanguageRelevanceType = By.id("reltype");
    By relocate = By.id("exampleRadios2");

    // Edit Contact Information
    public void getPhone(String phoneNumber){
        driver.findElement(elmPhone).clear();
        driver.findElement(elmPhone).sendKeys(phoneNumber);
        //log.info("Phone number is entered.");
    }
    // verify Contact record through phone number
    public String getPhoneNumber(){
        String actualPhone = driver.findElement(By.xpath("//h1[text()='Contact Information']/../p/br[2]")).getText();
        //log.info("Phone number is retrieved from the Profile Page.");
        return actualPhone;
    }
    public void getPhoneType(String phoneType){
        WebElement elmPhoneType = driver.findElement(By.id("phonetype"));
        Select selectObj = new Select(elmPhoneType);
        selectObj.selectByValue(phoneType);
    }


    // Edit Location
    public void getAddress1(String address1){
        driver.findElement(elmAddress1).clear();
        driver.findElement(elmAddress1).sendKeys(address1);
    }
    public void getAddress2(String address2){
        driver.findElement(elmAddress2).clear();
        driver.findElement(elmAddress2).sendKeys(address2);
    }
    public void getCountry(String country){
        driver.findElement(elmCountry).clear();
        driver.findElement(elmCountry).sendKeys(country);
    }
    public void getPostcode(String postcode){
        driver.findElement(elmPostcode).clear();
        driver.findElement(elmPostcode).sendKeys(postcode);
    }
    public void getTown(String town){
        driver.findElement(elmTown).clear();
        driver.findElement(elmTown).sendKeys(town);
    }

    // Edit Summary Method
    public void editSummary(String summary) {
        //driver.findElement(assertSummaryPage).isDisplayed();
        driver.findElement(editsummary).clear();
        driver.findElement(editsummary).sendKeys(summary);
    }
    //Edit Link Methods
    public void editLinkURL(String url) {
        driver.findElement(editLinkURL).sendKeys(url);
    }

    public void editLinkDescription(String descn) {
        driver.findElement(editDescription).sendKeys(descn);
    }
    // Edit Summary Method

    // Skills Methods
    public void setEnterSkill(String text) {
        driver.findElement(enterSkill).sendKeys(text);
    }
    public void setSkillType(String skillType) {
        WebElement elmSkill = driver.findElement(selectSkillType);
        Select selectObj = new Select(elmSkill);
        selectObj.selectByValue(skillType);
    }

    // Add Work Authorisation
    public void setWorkAuthorisation(String workEditAuthorisation) {
        driver.findElement(authorisation).sendKeys(workEditAuthorisation);
    }

    //Add Languages
    public void setEditLanguage(String language) {
        WebElement elmLang = driver.findElement(editLanguage);
        Select selectobj1 = new Select(elmLang);
        selectobj1.selectByValue(language);
    }

    //Edit Relevance Type
    public void setRelevanceType(String relevanceType) {
        WebElement elmRT = driver.findElement(editlanguageRelevanceType);
        Select selectobj2 = new Select(elmRT);
        selectobj2.selectByValue(relevanceType);
    }

    public void setRelocate() {

        driver.findElement(relocate).click();
    }

    public void setTravel(String inputTravel) {
        if (inputTravel.equalsIgnoreCase("Up to 100%")) {
            String[] travel = {"Up to 100%", "Up to 25%", "Up to 50%", "Up to 75%", "No travel required"};
            String travelOption;
            for (int i = 0; i < 6; i++) {
                travelOption = (travel[i]);
                switch (Integer.parseInt(travelOption)) {

                    case 0:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
                        break;
                    case 1:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
                        break;
                    case 2:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
                        break;
                    case 3:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
                        break;

                    default:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
                }
            }
        }
    }
}

//    String[] travel = {"No travel required","Up to 100%","Up to 50%","Up to 75%","Up to 25%"};
//    public void setTravel1(String travelchoice) {
//        switch(String[] travel)
//        case "No travel required":
//            driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
//        case(travel=[1]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
//        case(travel=[2]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
//        case(travel=[3]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
//        case(travel=[4]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
//    }

//    By travel = By.id("exampleRadios2").;
//            driver.findElement(travel).click();
//
//    By travel = By.id("exampleRadios2");
//            driver.findElement(travel).click();

// Add Additional Information-Relocate
//    public void setRelocate(){
//        By relocate = By.id("exampleRadios1");
//        driver.findElement(relocate).click();
//    }

