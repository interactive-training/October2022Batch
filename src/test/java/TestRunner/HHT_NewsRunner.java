package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/java/HHT_Features",
        glue = "HHT_Steps",
        monochrome = true,
<<<<<<< HEAD:src/test/java/HHT_TestRunner.java
        //publish = true,
        tags = "@Donations",//"@Poojas",//"@Events",//"@Calendar",//"@familyMembers",//"@viewOrders",//"@viewMembers",//"@deleteMembers",//"@adminViewDonations",//"@adminEditDonations",//"@createNewsletter",//"@createNewsletter",git//"@deleteNewsletter" ,//"@editPoojas",//"@viewPoojas"//"@createPoojas",//"@editNews",//"@createEvent", //"@events",//"@events-end-end",
=======
        publish = true,
        tags = "@CreateNews or @EditNews or @ViewNews or @DeleteNews",
>>>>>>> 690cea874ab8cf345110fcc21424585462e49831:src/test/java/TestRunner/HHT_NewsRunner.java

        plugin = {"pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "rerun:target/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                // "com.aventstack:extentreports-cucumber7-adapter:${1.14.0}"
        }
)
public class HHT_NewsRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}

