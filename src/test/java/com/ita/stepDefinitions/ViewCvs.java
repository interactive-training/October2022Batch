package com.ita.stepDefinitions;

import com.ita.pages.JobSeekersPage;
import com.ita.util.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class ViewCvs {

//    Hooks hooks;

    WebDriver driver;

    TestContext testContext;

    public ViewCvs(TestContext testContext) {
        this.testContext = testContext;

    }


    @Given("the user launched the ViewCV url")
    public void the_user_launched_the_viewcvs_url() throws IOException {

        System.out.println("the user launched the viewcv url");

        //how to access home page ?

        testContext.getHomePage().OpenURL();


//        System.out.println(testContext.getHomePage().getBrowserTitle());

    }

//    @Given("the user logged into Jobseekers account with valid credentials")
//    @When("^the user logged into Jobseekers account with valid credentials \"(.*)\" and \"(.*)\"$")
    @When("the user logged into Jobseekers account with valid credentials {string} and {string}")
    public void the_user_logged_into_Jobseekers_account_with_valid_credentials(String userEmail, String password){
        System.out.println("the_user_logged_into_Jobseekers_account_with_valid_credentials...");
        //which page ?

        //click jobseekers

        testContext.getHomePage().clickJobSeekersLinkOnTop();
        testContext.getJobSeekersPage().loginJobSeeker(userEmail,password);

    }


    @And("the user navigates to the Work Experience tab")
    public void theUserNavigatesToTheWorkExperienceTab() {
        System.out.println("theUserNavigatesToTheWorkExperienceTab..");
        Assert.assertTrue(true);
    }

    @And("clicks on add button")
    public void clicksOnAddButton() {
        System.out.println("clicksOnAddButton..");
        
    }

//    @Then("it should navigate to Experience page")
//    public void itShouldNavigateToExperiencePage() {
//        System.out.println("testing...");
//    }
//


}
