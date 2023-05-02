package com.ita.stepDefinitions;

import com.ita.util.TestContext;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ViewCvs1 {

    public static final Logger log = LogManager.getLogger(ViewCvs1.class.getName());

    Hooks hooks;

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
