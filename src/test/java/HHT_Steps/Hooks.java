package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(CRUD_Donations.class);

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) throws IOException {

        logger.info("Before test executed : " + scenario.getName());

        this.driver = testContext.getDriver();

        System.out.println(driver.getTitle());
    }

    @After
    public void teardown(Scenario scenario){
        logger.info("tear down executed : " + scenario.getName());

        this.driver.quit();
        System.out.println("Closing browser in tearDown");
    }
}
