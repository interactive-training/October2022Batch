package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setup() throws IOException {
        this.driver = testContext.getDriver();
        System.out.println(driver.getTitle());
    }

    @After
    public void teardown(){
        this.driver.quit();
        System.out.println("Closing browser in tearDown");
    }
}
