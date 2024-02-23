package HomeRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = "src/test/java/Homepage/CrudPoojas.feature",
        glue = "HomeStep"
)
public class Home extends AbstractTestNGCucumberTests {

}
