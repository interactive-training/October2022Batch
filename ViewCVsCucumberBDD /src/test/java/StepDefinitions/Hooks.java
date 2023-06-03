package StepDefinitions;

import Utililities.TestContext;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext testContext){
        this.testContext = testContext;    // we are calling this constructor so we can call this testContext in any method
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

    @BeforeStep
    public void beforeStep(Scenario scenario) throws IOException {    // why it is not importing?

        if (scenario.isFailed()) {
            //screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");

        }

    }
    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcepath);
            scenario.attach(fileContent,"image/png", "image");
        }
    }
}
