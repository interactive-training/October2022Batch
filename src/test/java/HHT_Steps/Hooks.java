package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import org.testng.Reporter; //used to get the browser property from testng xml file

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    WebDriver driver;
    private Logger logger = LogManager.getLogger(this.getClass());

    public Hooks(TestContext testContext) throws IOException {
        this.testContext = testContext;
        driver = testContext.getDriver();
    }

    @Before
    public void setup(Scenario scenario) throws IOException {

//        Logger logger = LogMe.getMyLogger(this.getClass());
        logger.info("Before test executed : " + scenario.getName());

        String browserPropertyFromTestNGXML = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

        if (browserPropertyFromTestNGXML != null) {
            this.driver = testContext.createWebDriverForMultiBrowser(browserPropertyFromTestNGXML);
        }
        else{
            this.driver = testContext.createWebDriver(); // it takes care of local run from property file or command line
        }
//        this.driver = testContext.getDriver();

//        System.out.println(driver.getTitle());
    }

    @After
    public void teardown(Scenario scenario) throws IOException {

//        Logger logger = LogMe.getMyLogger(this.getClass());
        logger.info("tear down executed : " + scenario.getName());

        if(scenario.isFailed())
        {
            scenario.attach(testContext.getByteScreenshot(), "image/png", scenario.getName());
        }

        this.driver.quit();
        System.out.println("Closing browser in tearDown");
    }
}
