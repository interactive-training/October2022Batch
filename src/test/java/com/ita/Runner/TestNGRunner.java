package com.ita.Runner;


import com.ita.util.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


@CucumberOptions(
        features = "src/test/java/com/ita/features",
        glue = {"com.ita.stepDefinitions"},
        monochrome = true,
        tags = "@chrome",

//        tags = "~@Ignore",
//        format = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json",
//                "rerun:target/cucumber-reports/rerun.txt"},
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber-reports/CucumberTestReport.json"
                }

    )

public class TestNGRunner extends AbstractTestNGCucumberTests {

//
//     <parameter name="RunOption" value="grid"></parameter>
//        <parameter name="browser" value="chrome"></parameter>
//
//        <parameter name="platform" value="Windows"></parameter>
//        <parameter name="browserVersion" value="ANY"></parameter>
    @Parameters({ "browser", "runoption", "platform", "browserVersion" })
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser, @Optional("local") String runoption, @Optional("") String platform, @Optional("") String browserVersion) throws Exception {

        if (browser.isEmpty()){
            System.out.println("Executing from IDE...");
            return;

        }

        System.out.println("@BeforeTest annotation in cucumberTestNG Runner class");
        System.out.println("paramter passed to beforeTest is: browserType = " + browser);

        if (runoption.equalsIgnoreCase("local")){
            new DriverManager().initializeDriver(browser);
        }
        else{
//            browser, String runoption, String platform, String browserVersion) throws Exception {
            new DriverManager().initializeDriverGrid(browser,platform,browserVersion);

        }

    }

    @AfterTest
    public void afterTest() throws Exception {

        System.out.println("@BeforeTest annotation in cucumberTestNG Runner class");
//        System.out.println("paramter passed to beforeTest is: browserType = " + browserType);
        DriverManager.driversCollection.get().close();
        DriverManager.driversCollection.get().quit();
        DriverManager.driversCollection.remove();

    }
}

