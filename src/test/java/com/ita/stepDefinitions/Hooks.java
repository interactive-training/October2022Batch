package com.ita.stepDefinitions;

import com.ita.util.TestContext;
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

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setup() throws IOException {
        this.driver = testContext.getDriver();
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown() throws IOException {
        System.out.println("Closing browser in tearDown");
        this.driver.quit();

    }

    @BeforeStep
    public void beforeStep(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            //screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");

        }

    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            //screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");

        }

    }

}
