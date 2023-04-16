package com.ita.cucumberTestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/com/ita/features",
        glue = {"com.ita.stepDefinitions"},
        monochrome = true,

//        tags = "~@Ignore",
//        format = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json",
//                "rerun:target/cucumber-reports/rerun.txt"},
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class TestRunner extends AbstractTestNGCucumberTests {

}