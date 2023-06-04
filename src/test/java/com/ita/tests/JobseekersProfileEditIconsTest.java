package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.*;
import org.testng.annotations.Test;

public class JobseekersProfileEditIconsTest extends BaseTest {
    @Test
    public void contactInformation() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickContact();

        JobSeekersProfileEditIconsPage editContact = new JobSeekersProfileEditIconsPage(driver);
        editContact.getPhone("76543890");
        editContact.getPhoneType("Work");
        editContact.clickSaveButton();
    }
    @Test
    public void location() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickLocation();


        JobSeekersProfileEditIconsPage editLocation = new JobSeekersProfileEditIconsPage(driver);
        editLocation.getAddress1("26");
        editLocation.getAddress2("Manor Road");
        editLocation.getCountry("USA");
        editLocation.getTown("Boston");
        editLocation.getPostcode(" BO3 6FH");
    }
    @Test
    public void summary() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickSummary();

        JobSeekersProfileEditIconsPage editSummary = new JobSeekersProfileEditIconsPage(driver);
        editSummary.editSummary("This is my 3 years summary.");
        editSummary.clickSaveButton();
    }

    @Test
    public void links() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickLink();
        JobSeekersProfileEditIconsPage editLinks = new JobSeekersProfileEditIconsPage(driver);
//        String expected_Title
//        Assert.assertTrue(editLinks.getBrowserTitle().contains(expected_Title), "Both titles are not matching");

        editLinks.editLinkURL("https://www.ebay.co.uk/");
        editLinks.editLinkDescription("EBay");
        editLinks.clickSaveButton();
        // saveChangesButton() is in BasePage as JobseekersProfileOtherAddButtonsPage/JobSeekersLoginPage
        // extends BasePage any of these page's object( js/editSummary/editLinks/editSkills) can be used to call it.
    }
    @Test
    public void skills() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickSkills();

        JobSeekersProfileEditIconsPage editSkills = new JobSeekersProfileEditIconsPage(driver);
        editSkills.setEnterSkill("Java");
        editSkills.setSkillType("Intermediate");
        editSkills.clickSaveChanges();
    }

    @Test
    public void workAuthorisationEdit() {
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickWorkAuthorisationEdit();

        JobSeekersProfileEditIconsPage editWorkAuthorisation = new JobSeekersProfileEditIconsPage(driver);
        editWorkAuthorisation.setWorkAuthorisation("United Kingdom, France,Spain");
        editWorkAuthorisation.clickSaveButton();
    }

    @Test
    public void languages(){
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.clickLanguages();

        JobSeekersProfileEditIconsPage editLanguages = new JobSeekersProfileEditIconsPage(driver);
        editLanguages.setEditLanguage("German");
        editLanguages.setRelevanceType("Intermediate");
        editLanguages.clickSaveButton();
    }

    @Test
    public void additionalInformationRelocate(){
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));
        JobSeekersLandingPage.setClickRelocate();

        JobSeekersProfileEditIconsPage addRelocate = new JobSeekersProfileEditIconsPage(driver);
        addRelocate.setRelocate();
        addRelocate.clickSaveButton(); // defect taking to Add Award Page
    }
    @Test
    public void additionalInformationTravel() throws InterruptedException {
        String inputTravel = "2";
        HomePage.clickJobSeekersLinkOnTop();
        JobSeekersLoginPage.loginJobSeeker(prop.getProperty("jobseekersUsername"), prop.getProperty("jobseekersPassword"));

        JobSeekersProfileEditIconsPage addRelocate = new JobSeekersProfileEditIconsPage(driver);
        JobSeekersLandingPage.setClickTravel();
        //addTravel.setTravel(inputTravel);
        Thread.sleep(3000);
       // addTravel.clickSaveButton(); // defect taking to Add Award Page
    }
}
