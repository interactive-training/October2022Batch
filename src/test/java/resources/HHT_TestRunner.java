package resources;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/HHT_Features/Payment.feature",
        glue = "HHT_Steps"
)
public class HHT_TestRunner extends AbstractTestNGCucumberTests {

}