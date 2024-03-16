import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features= "src/test/java/HHT_features/CRUD_Event.feature",
        glue = "HHT_Steps",
        tags = "@editEvent"
)
public class HHT_TestRunner extends AbstractTestNGCucumberTests {
//   // @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenario(){
//        return super.scenarios();
//    }
}
