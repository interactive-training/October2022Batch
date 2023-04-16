package com.ita.stepDefinitions;


import com.ita.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class test_steps1 {

    WebDriver driver;
    test_steps1(BaseTest base){
        driver = base.getDriver();
    }

    @When("I do something")
    public void i_do_something() {
        // Write code here that turns the phrase above into concrete actions

        System.out.println(driver.getTitle());
    }
    @Then("I validate something")
    public void i_validate_something() {
        // Write code here that turns the phrase above into concrete actions

        System.out.println(driver.getTitle());
    }

}
