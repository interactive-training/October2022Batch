package com.ita.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ita.pages.HomePage;
import com.ita.util.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends Utility {

    protected ExtentReports extentReports = null;

    protected ExtentTest extentTest;

    protected WebDriver driver;
    //why protected ? it will work with public as well, but just do not throught out anyone should use this driver objet,
    // protected means you are allowing those classes to use it who extends this class, not just anyone by creating a new objet of it.

    protected HomePage homepage;

    static Properties prop; //because I may use this property value from anywhere in the project, improvement -> cretea class and creae one method for one property. ?? ==> homework


    public void InitializeDriver(String paramBrowserType) throws IOException {

        //WebDriverManager -- if local system has un restricted internet connetion, we can use this to setup browser drvers automatically
//        https://github.com/bonigarcia/webdrivermanager


        //read properties file

        prop = new Properties();

        String propFilePath = System.getProperty("user.dir") + "/src/test/java/resources/Config.properties";

        File myFile = new File(propFilePath);

        FileInputStream fis = new FileInputStream(myFile);

        prop.load(fis);

        //get browser property
        String browserType = prop.getProperty("BrowserType");


        //if paramter passed as browserName, then overwrite
        if (paramBrowserType.contains("chrome"))
            browserType = "chrome";
        else if (paramBrowserType.contains("firefox"))
            browserType = "firefox";
        else if (paramBrowserType.contains("edge"))
            browserType = "edge";



        if (browserType.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }
        else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        //maximizze
        driver.manage().window().maximize();

        //set implicitwai time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImpilcitTimeInSec","10"))));

    }

    @Parameters("paramBrowserType")
    @BeforeMethod
    public void beforeMethod(Method method, ITestContext iTestContext, String paramBrowserType) throws IOException {
        //In BeforeMethod , we cannot get IResult objet, it is a null objet, result objet will be filled up after a test execution, so in test listener onTestStart is a place is - after test is initialied, but not finished, and result is filled up with at least test inforations.

        InitializeDriver(paramBrowserType);

        iTestContext.setAttribute("WebDriver", driver); //this is setting to uses in ExtentReport

        String url = prop.getProperty("URL");

        driver.get(url);

        homepage =  new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {

//        driver.close();
        driver.quit();

    }

    public WebDriver getDriver(){
        return driver;
    }

}
