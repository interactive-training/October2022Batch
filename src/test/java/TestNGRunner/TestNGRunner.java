package TestNGRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/Features", glue="StepDefinations")
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
