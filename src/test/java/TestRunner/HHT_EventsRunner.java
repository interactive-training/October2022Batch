package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/java/HHT_Features",
        glue = "HHT_Steps",
        monochrome = true,
        publish = true,
        tags="@events",
//        tags = "@CreateEvent or @EditEvent or @ViewEvent or @DeleteEvent",

        plugin = {"pretty", "html:target/cucumber-reports3.html",
                "json:target/cucumber3.json",
                "rerun:target/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                // "com.aventstack:extentreports-cucumber7-adapter:${1.14.0}"
        }
)
public class HHT_EventsRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }
}

//"@viewEvent"  "@editEvent" "@deleteEvent"  "@createEvent"