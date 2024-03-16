package HHT_Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DependencyInjectorAndHooks {

    //
    WebDriver driver;

    private TestContext testContext;
    private Properties prop;

    public DependencyInjectorAndHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    //set the driver inside TestContext , which would be shared across steps files...
    // like setDriver( chrome driver), but this should exeute very first step, so we are writing in Before hooks (which will be exeuted first before any step method exeutes)

    //here the trick is, we canno create constructor to set the driver for testcontext, because when creates the testcontext object avove,
    // uur driver would not be created, in this class, first contructor exeutes, then hooks method (setup) executes
    // So, createing a public method - setDriver in testContext and setting the driver to use across steps metbhods


    public WebDriver intializeDriver() throws IOException {
        // Reading Properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
        prop.load(fis);

        //Get browser property from config file
        String browserType = prop.getProperty("BrowserType");

        // Override from command prompt
        String browserTypeFromCommandPrompt = System.getProperty("command.browser");
        System.out.println("BrowserType from command prompt:" + System.getProperty("command.browser"));

        if (browserTypeFromCommandPrompt != null){
            browserType = browserTypeFromCommandPrompt;
        }else if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        // Maximise browser window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("ImpilcitTimeInSec","10"))));

        //getLoginPage();
//        if (login.equalsIgnoreCase("admin")) {
//            System.getProperty(AdminUrl);
//        } else

        return driver;
    }



    @Before
    public void setUp() throws IOException {
        WebDriver driver = intializeDriver();
        testContext.setDriver(driver);


    }

    //
    @After
    public void teardown(){
        this.driver.quit();
        System.out.println("Closing browser in tearDown");
    }

}
