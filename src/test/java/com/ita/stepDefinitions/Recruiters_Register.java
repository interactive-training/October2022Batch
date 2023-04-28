package com.ita.stepDefinitions;

import com.ita.util.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Recruiters_Register {


    TestContext testContext;

    public Recruiters_Register(TestContext param_testContext){
        this.testContext = param_testContext;
    }


    // backgroud methods

    @Given("User in home page")
    public void user_in_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Welcome to Viewcvs.co.uk", testContext.getHomePage().getBrowserTitle());
    }


    @When("User clicks {string} button")
    public void user_clicks_button(String buttonText) {
        // Write code here that turns the phrase above into concrete actions

        if (buttonText.equalsIgnoreCase("JobSeekers") ){
            //click job seekers
            testContext.getHomePage().clickJobSeekersLinkOnTop();

        }
        else if (buttonText.equalsIgnoreCase("Recruiters") ) {
            testContext.getHomePage().clickRecruitersLinkOnTop();
        }
    }
    @When("User clicks Register link")
    public void user_clicks_register_link() {
        // Write code here that turns the phrase above into concrete actions

        testContext.getRecruitersPage().clickRegisterLink();

    }
//    @Then("User should be in Recruiters Registration page")
//    public void user_should_be_in_recruiters_registration_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    //


    @Given("User is on Registration page")
    public void user_is_on_registration_page() {

        String actualTitle = testContext.getRecruitersPage().getBrowserTitle();
        String expectedTitle = "Recruiter Register";

        //Assert
        Assert.assertEquals(actualTitle, expectedTitle, "User does not have registration page");

    }
    @When("User enters below data")
    public void user_enters_below_data(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();

        List<Map<String,String>> data = dataTable.asMaps();

        String firstname = data.get(0).get("Firstname");
        String lastname = data.get(0).get("Lastname");

        //enter the values in the page using driver/page object
        testContext.getRecruitersPage().enterFirstName(firstname);
        testContext.getRecruitersPage().enterLastName(lastname);

    }
    @Then("User should successfully create an account")
    public void user_should_successfully_create_an_account() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
