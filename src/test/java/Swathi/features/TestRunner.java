package Swathi.features;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "src/test/java/features/CRUD_Event.feature",
        glue = "Steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

//MyAccountExisting.feature