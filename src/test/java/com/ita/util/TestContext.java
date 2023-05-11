package com.ita.util;

import com.ita.pages.*;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestContext {

    public WebDriver driver;
    public String landingPageProductName;
    public Properties prop;

    public Map<Long, WebDriver> webDriverObjects = new HashMap<>();

    //Page variables
    private HomePage homePage;
    private JobsAndApplicationsPage jobsnappsPage;
    private JobSeekersPage jobseekerPage;
    private RecruitersPage recruitersPage;
    private WorkExperiencePage workExpPage;



    //


    public HomePage getHomePage() {

        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;

    }

    public JobsAndApplicationsPage getJobsAndApplicationsPage(){

        if (jobsnappsPage == null) {
            jobsnappsPage = new JobsAndApplicationsPage(driver);
        }

        return jobsnappsPage;

    }

    public JobSeekersPage getJobSeekersPage(){

        if (jobseekerPage == null) {
            jobseekerPage = new JobSeekersPage(driver);
        }

        return jobseekerPage;
    }

    public RecruitersPage recruitersPage(){
        if (recruitersPage == null) {
            recruitersPage = new RecruitersPage(driver);
        }
        return recruitersPage;
    }

//    public RecruitersPage recruitersPage; --- homework


//    public     private WorkExperiencePage workExpPage;  -- homework


    public String getBrowserType(){

        //preferences
        //1. command prompt

        //2. testng xml file data

        //3. read from property file

        String browserType = null;


        //check if any command prompt value passed ?
        String brwoserTypeFromCommandPrompt = System.getProperty("command.browser");

        if (brwoserTypeFromCommandPrompt != null) {
            browserType = brwoserTypeFromCommandPrompt;
            return browserType;
        }

        return browserType;

    }
//
//    public WebDriver initializeDriver_LocalSystem(String param_browserType) throws IOException {
//
//        //read properties file
//
//        prop = new Properties();
//
//        String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//
//        File myFile = new File(propFilePath);
//
//        FileInputStream fis = new FileInputStream(myFile);
//
//        prop.load(fis);
//
//        //get browser property
//        String browserType = prop.getProperty("browser");
//
//        System.out.println("browser type from command prompt ******** : " + System.getProperty("command.browser"));
//
//        // Override browser from command prompt
//        String brwoserTypeFromCommandPrompt = System.getProperty("command.browser");
//
//        if (brwoserTypeFromCommandPrompt != null) {
//            browserType = brwoserTypeFromCommandPrompt;
//        }
//
//        if (browserType.equalsIgnoreCase("chrome")) {
//
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--remote-allow-origins=*");
//
//            WebDriverManager.chromedriver().setup();
//
//            driver = new ChromeDriver(options);
//
////            DesiredCapabilities capability = DesiredCapabilities.chrome(options);
//
////            DesiredCapabilities caps = new DesiredCapabilities();
////101.1.1.1.1
////            caps.setBrowserName("chrome");
//
////            driver = new RemoteWebDriver(new URL("http://192.168.1.123:4444/wd/hub"), options);
//
//            driver.get("http://www.viewcvs.co.uk");
//
//        } else if (browserType.equalsIgnoreCase("firefox")) {
//
//            driver = new FirefoxDriver();
//        } else if (browserType.equalsIgnoreCase("edge")) {
//
//            driver = new EdgeDriver();
//        }
//
//        //maximizze
//        driver.manage().window().maximize();
//
//        //set implicitwai time
//
//        Integer implicitWaitFrom = Integer.parseInt(prop.getProperty("impilcitTimeInSec", "10"));
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitFrom));
//
//        //add this driver to the list
//
//        webDriverObjects.put(Thread.currentThread().getId(), driver);
//
//        return driver;
//    }


    @Before
    public void setup() throws Exception {

        this.driver = new DriverManager().initializeDriver("chrome");

        driver.get("http://www.viewcvs.co.uk");

//        System.out.println("@Before  annotation in cucumber setup method - hooks class.");
//        this.driver = DriverManager.getDriver();
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {

        System.out.println("@After annotation in Cucumber after method - Closing browser in tearDown");

//        this.driver = DriverManager.getDriver();
        this.driver.quit();

    }

    @BeforeStep
    public void beforeStep(Scenario scenario) throws IOException {
        System.out.println("@BeforeStep annotation for Cucumber - in beforeStep method");
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        System.out.println("@AfterStep annotation for Cucumber - in beforeStep method");

        if (scenario.isFailed()) {
            //screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");

        }

    }
    
}