package Utilities;

import HHT_Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestContext {
    public WebDriver driver;
    public Properties prop;
    // Pages variables
    private LoginPage loginPage;


    // methods for creating a new driver or passing the previous one to the next page
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

//    @Before
//    public void setUp() throws IOException {
 //       this.driver = testContext.intializeDriver();
//        System.out.println(driver.getTitle());
//    }

    @After
    public void teardown(){
        this.driver.quit();
        System.out.println("Closing browser in tearDown");
    }
    //Initialising the driver
    public WebDriver intializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
        prop.load(fis);

        //get browser property from config file
        String browserType = prop.getProperty("BrowserType");

        // Override from command prompt
        String browserTypeFromCommandPrompt = System.getProperty("command.browser");
        System.out.println("BrowserType from command prompt:" + System.getProperty("command.browser"));

        if (browserTypeFromCommandPrompt != null){
            browserType = browserTypeFromCommandPrompt;
        }else if (browserType.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        // Maximise browser window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("ImpilcitTimeInSec","10"))));
        return driver;
    }
}

