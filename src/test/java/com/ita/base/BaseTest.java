package com.ita.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.ita.pages.HomePage;
import com.ita.util.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Listeners(BaseTest.class)
public class BaseTest implements ITestListener {

     protected static ExtentReports extentReports = ExtentReportObject.getExtentReportObject();

     private ExtentTest extentTest;
     protected static HashMap<Long, ExtentTest> extentTests = new HashMap();


    protected WebDriver driver;
    protected static  HashMap<Long,WebDriver> webDriverObjects = new HashMap<>();

    //why protected ? it will work with public as well, but just do not throught out anyone should use this driver objet,
    // protected means you are allowing those classes to use it who extends this class, not just anyone by creating a new objet of it.

    protected HomePage homepage;

    static Properties prop; //because I may use this property value from anywhere in the project, improvement -> cretea class and creae one method for one property. ?? ==> homework

    public void InitializeDriver() throws IOException {

        //read properties file

        prop = new Properties();

        String propFilePath = System.getProperty("user.dir") + "/src/test/java/resources/Config.properties";

        File myFile = new File(propFilePath);

        FileInputStream fis = new FileInputStream(myFile);

        prop.load(fis);

        //get browser property
        String browerType = prop.getProperty("BrowserType");

        System.out.println("browser type from command prompt ******** : " + System.getProperty("command.browser"));

        // Override browser from command prompt
        String brwoserTypeFromCommandPrompt = System.getProperty("command.browser");
        if (brwoserTypeFromCommandPrompt != null)
            browerType = brwoserTypeFromCommandPrompt;

        if (browerType.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }
        else if(browerType.equalsIgnoreCase("firefox")){

            driver = new FirefoxDriver();
        }
        else if(browerType.equalsIgnoreCase("edge")){

            driver = new EdgeDriver();
        }


        //maximizze
        driver.manage().window().maximize();

        //set implicitwai time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImpilcitTimeInSec","10"))));

        //add this driver to the list
        webDriverObjects.put(Thread.currentThread().getId(), driver);

    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, ITestContext iTestContext) throws IOException {
        //In BeforeMethod , we cannot get IResult objet, it is a null objet, result objet will be filled up after a test execution, so in test listener onTestStart is a place is - after test is initialied, but not finished, and result is filled up with at least test inforations.
        InitializeDriver();


//        iTestContext.setAttribute("WebDriver", getDriver);

        String url = prop.getProperty("URL");

        getDriver().get(url);

        homepage =  new HomePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iTestResult) throws IOException {

//        driver.close();
        getDriver().quit();

    }

    public WebDriver getDriver(){

        return webDriverObjects.get(Thread.currentThread().getId());

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName(), iTestResult.getMethod().getDescription());
//        Store this object
        extentTests.put(Thread.currentThread().getId(), extentTest);

    }

    public ExtentTest getCurrentExtentTest(){
        return extentTests.get(Thread.currentThread().getId());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        getCurrentExtentTest().log(Status.PASS, "Test case is passed. This is written in onTestSuccess listerner method.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        getCurrentExtentTest().log(Status.FAIL, "Test case is failed. This is written in onTestFailed listerner method., ok,after that what to do ? shall we take screenshot and attach ? following code will that.");
        getCurrentExtentTest().log(Status.FAIL, iTestResult.getThrowable());

        String testname = iTestResult.getMethod().getMethodName();


        //add screenshot to the test
        try {
            String screenshotPath = Utility.getScreenShotFilePath(getDriver(),testname);
            getCurrentExtentTest().log(Status.INFO, "The current screenshot path is : " + screenshotPath );

            getCurrentExtentTest().addScreenCaptureFromBase64String (Utility.getScreenShotAsBase64(getDriver(),testname));
//            getCurrentExtentTest().log(Status.INFO, (Markup) MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //add screenshot to the log


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("test - onStart - can get iTestContext object");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
