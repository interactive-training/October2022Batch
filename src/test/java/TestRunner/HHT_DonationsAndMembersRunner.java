package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/java/HHT_Features",
        glue = "HHT_Steps",
        monochrome = true,
        publish = true,
        tags = "@adminViewDonations",
//        tags = "@adminViewDonations or @adminEditDonations or @viewMembers or @deleteMembers",

        plugin = {"pretty", "html:target/cucumber-reports2.html",
                "json:target/cucumber2.json",
                "rerun:target/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class HHT_DonationsAndMembersRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }
}

//"@viewEvent"  "@editEvent" "@deleteEvent"  "@createEvent"