package com.ita.stepDefinitions;


import com.ita.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test_steps extends BaseTest {



    @Given("I have something")
    public void i_have_something() {
        // Write code here that turns the phrase above into concrete actions

        System.out.println(driver.getTitle());
    }
    @When("I do something")
    public void i_do_something() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I validate something")
    public void i_validate_something() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
