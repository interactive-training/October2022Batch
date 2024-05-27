package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRUD_Newsletter {

    WebDriver driver;
    TestContext testContext;

    public CRUD_Newsletter(TestContext testContext){
        this.testContext = testContext;
    }


    //    *******--------Create NewsLetter Front-End Panel ---------************

    @Given("browser is open")
    public void browser_is_open() throws IOException {
        testContext.getLoginPage().getWebsiteURL();

    }
    @When("user enters email address {string}")
    public void userEntersEmailAddress(String Emailid) {
        //Enter Email Address
       testContext.getNewsLetter_homePage().Newsletteremail(Emailid);


    }

    @When("user clicks on sign up")
    public void user_clicks_on_sign_up()  {
        // Sign up the Page

     testContext.getNewsLetter_homePage().NewsLetterSignup();

    }

    @Then("user navigated to the newsletter page")
    public void user_navigated_to_the_newsletter_page() {
        // NewsLetter Page Open
        testContext.getNewsLetter_confirmationPage().verifyAddNewsLetterHeader();
        System.out.println("Successfully go to NewsLetter Front End Home Page");

    }


//    }
    @When("User clicks on NewsLetter Subscribers menu")
    public void User_clicks_on_NewsLetter_Subscribers_menu(){
        testContext.getAdministrationPanelPage().clickNewsLetter();
    }
    @Then("user should get News Letter Subscriber Details page")
    public void userShouldGetNewsLetterSubscriberDetailsPage() {
        testContext.getNewsLetterSubscriberDetails_Page().verifyNewsLetterSubscriberDetailsHeader();
    }


    //*************--------Deleting NewsLetter----------*********

    @When("admin user clicks on delete action button of {string}")
    public void adminUserClicksOnDeleteActionButtonOf(String EmailField)  {
        testContext.getNewsLetterSubscriberDetails_Page().DeleteNewsLetter(EmailField);
//
           }

    @Then("newsletter should be deleted successfully")
    public void newsletter_should_be_deleted_successfully()
    {
        // Newsletter Deleted Successfully
        System.out.println("Newsletter Subscriber Deleted Successfully");
    }



}

