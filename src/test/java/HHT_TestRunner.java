import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= "src/test/java/HHT_features/CRUD_Event.feature",
        glue = "HHT_Steps"
)
public class HHT_TestRunner extends AbstractTestNGCucumberTests {
}

//MyAccountExisting.feature