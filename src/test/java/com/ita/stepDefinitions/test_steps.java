package com.ita.stepDefinitions;


import com.ita.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class test_steps {

    WebDriver driver;

    test_steps(BaseTest base){
        driver = base.getDriver();
    }

    @Given("I have something")
    public void i_have_something() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(driver.getTitle());

    }


}
