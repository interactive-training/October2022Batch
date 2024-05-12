package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/java/HHT_Features",
        glue = "HHT_Steps",
        monochrome = true
        //publish = true,
//       ,tags =  "@adminViewDonations" // "@DNL" ,  // "@deletePooja", //"@editPoojas",//"@viewPoojas"//"@createPoojas",//"@editNews",//"@createEvent", //"@events",//"@events-end-end",
        ,plugin = {"pretty"
                ,"html:target/cucumber-reports.html"
                ,"json:target/cucumber.json"
                ,"rerun:target/failed_scenarios.txt"
//                ,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                // "com.aventstack:extentreports-cucumber7-adapter:${1.14.0}"
        }
)
public class HHT_TestRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }
}

//"@viewEvent"  "@editEvent" "@deleteEvent"  "@createEvent"