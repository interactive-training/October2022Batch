package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobSeekersProfileOtherFields {
    TestContext testContext;

    public JobSeekersProfileOtherFields(TestContext testContext){
        this.testContext = testContext;
    }

    @When("User fills all fields and presses save button")
    public void userFillsAllFieldsAndPressesSaveButton() {
        //Contact Information
        testContext.getJobSeekersProfileOtherFieldsPage().clickContact();
        testContext.getJobSeekersProfileOtherFieldsPage().getPhone("7651253765");
        testContext.getJobSeekersProfileOtherFieldsPage().getPhoneType("Mobile");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        // Location
        testContext.getJobSeekersProfileOtherFieldsPage().clickLocation();
        testContext.getJobSeekersProfileOtherFieldsPage().getAddress1("19");
        testContext.getJobSeekersProfileOtherFieldsPage().getAddress2("Manor Road");
        testContext.getJobSeekersProfileOtherFieldsPage().getCountry("United Kingdom");
        testContext.getJobSeekersProfileOtherFieldsPage().getPostcode("TW1 3DH");
        testContext.getJobSeekersProfileOtherFieldsPage().getTown("ABC");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();;

        //Summary
        testContext.getJobSeekersProfileOtherFieldsPage().clickSummary();
        testContext.getJobSeekersProfileOtherFieldsPage().editSummary("I have extensive experience in Java.");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Links
        testContext.getJobSeekersProfileOtherFieldsPage().clickLink();
        testContext.getJobSeekersProfileOtherFieldsPage().editLinkURL("https://www.ebay.co.uk/");
        testContext.getJobSeekersProfileOtherFieldsPage().editLinkDescription(" Ebay Project");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();
        //Skills
        testContext.getJobSeekersProfileOtherFieldsPage().clickSkills();
        testContext.getJobSeekersProfileOtherFieldsPage().setEnterSkill("Java");
        testContext.getJobSeekersProfileOtherFieldsPage().setSkillType("Advanced");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Work Authorisation
        testContext.getJobSeekersProfileOtherFieldsPage().clickAddWorkAuthorisation();
        testContext.getJobSeekersProfileOtherFieldsPage().setWorkAuthorisation("France and Germany");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Languages
        testContext.getJobSeekersProfileOtherFieldsPage().clickLanguages();
        testContext.getJobSeekersProfileOtherFieldsPage().setEditLanguage("French");
        testContext.getJobSeekersProfileOtherFieldsPage().setRelevanceType("Beginner");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Certifications
        testContext.getJobSeekersProfileOtherFieldsPage().setClickAddCertifications();
        testContext.getJobSeekersProfileOtherFieldsPage().setAddCertificationName(" Core Java");
        testContext.getJobSeekersProfileOtherFieldsPage().setAddCertificationSummary("I have 3 years of experience.");
        testContext.getJobSeekersProfileOtherFieldsPage().setAddYearAcquiredCertification("2000");
        testContext.getJobSeekersProfileOtherFieldsPage().setAddMonthAcquiredCertification("09");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Awards
        testContext.getJobSeekersProfileOtherFieldsPage().setClickAddAwards();
        testContext.getJobSeekersProfileOtherFieldsPage().setAddAwardName("Team Optimisation");
        testContext.getJobSeekersProfileOtherFieldsPage().setAddAwardDescription("It was for advancing into a senior role.");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Extracurriculars
        testContext.getJobSeekersProfileOtherFieldsPage().setClickAddExtracurriculars();
        testContext.getJobSeekersProfileOtherFieldsPage().setAddExtracurriculars("Badminton Club");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        //Additional Information
        testContext.getJobSeekersProfileOtherFieldsPage().setClickRelocate();
        testContext.getJobSeekersProfileOtherFieldsPage().setRelocate();
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

        testContext.getJobSeekersProfileOtherFieldsPage().setClickTravel();
        testContext.getJobSeekersProfileOtherFieldsPage().setTravel("                  Up to 100% ");
        testContext.getJobSeekersProfileOtherFieldsPage().saveChangesButton();

//        //Awards
//
//        testContext.getJobSeekersProfileOtherFieldsPage().setSaveChangesButton();
    }


    @Then("All the details entered should be updated")
    public void allTheDetailsEnteredShouldBeUpdated() {
        System.out.println("All the details are updated");

    }



}
