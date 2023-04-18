package com.ita.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


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
        plugin = {"html:target/cucumber.html", "json:target/cucumber-reports/CucumberTestReport.json"}

    )


public class TestNGRunner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

}