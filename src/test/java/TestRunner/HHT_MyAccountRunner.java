package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/java/HHT_Features",
        glue = "HHT_Steps",
        monochrome = true,
        //publish = true,
        tags = "@familyMembers",//"@Calendar",//"@Events","//@Poojas",//"@Donations",

        plugin = {"pretty", "html:target/cucumber-reports4.html",
                "json:target/cucumber4.json",
//                "rerun:target/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                // "com.aventstack:extentreports-cucumber7-adapter:${1.14.0}"
        }
)
public class HHT_MyAccountRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }

}