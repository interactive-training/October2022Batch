package com.ita.stepDefinitions;

import com.ita.util.TestContext;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ViewCvs1 {

//    Hooks hooks;

    WebDriver driver;

    TestContext testContext;


    public ViewCvs1(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("it should navigate to Experience page")
    public void itShouldNavigateToExperiencePage() {
        System.out.println("itShouldNavigateToExperiencePage...");
    }


}
