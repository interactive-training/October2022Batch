package HHT_Steps;

import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scenario) throws IOException {
        System.out.println("Scenario:" + scenario.getName());
        this.driver = testContext.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        this.driver.quit();
        System.out.println("End of scenario:" + scenario.getName());
    }
}
