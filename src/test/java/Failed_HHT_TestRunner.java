import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "@target/failed_scenarios.txt",
        glue = "HHT_Steps",
        monochrome = true,
        publish = true,
        tags = "@events-end-end",
        plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                // "com.aventstack:extentreports-cucumber7-adapter:${1.14.0}"
        }
)
public class Failed_HHT_TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}

//"@viewEvent"  "@editEvent" "@deleteEvent"  "@createEvent"