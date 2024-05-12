package HHT_Steps;

//import Utilities.ExtentReports.ExtentManager;
//import Utilities.ExtentReports.ExtentTestManager;
import Utilities.TestContext;
import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
//import io.cucumber.messages.types.TestStepResultStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

//import static Utilities.ExtentReports.ExtentTestManager.startTest;
//import static io.cucumber.core.runner.TestStepResultStatusMapper.STATUS;

public class Hooks {
    TestContext testContext;
    WebDriver driver;

    private static final Logger logger = LogManager.getLogger(Hooks.class.getName());


    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }


    @Before()
    public void setup() throws IOException {
        this.driver = testContext.getDriver();
        System.out.println(driver.getTitle());
        logger.info("before method calling");
//        ExtentTestManager.startTest("method ", "step name ");

    }


//    ====================================After hooks ===============

    @After
    public void after_each_Scenario(Scenario scenario){

        String sts = String.valueOf(scenario.getStatus());
        String scenarioName = scenario.getName();

        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        this.driver.quit();

//        if (scenario.isFailed()) {
//            System.out.println("The scenario failed: " + scenario.getName());
//            // You can also add extra information or screenshots here if you wish.
//        }
//        else {
//            System.out.println("The scenario was successful: " + scenario.getName());
//        }

    }


}
