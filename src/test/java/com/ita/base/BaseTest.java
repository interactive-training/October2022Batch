package com.ita.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ita.pages.HomePage;
import com.ita.util.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
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

    public void InitializeDriver() throws IOException {

        //read properties file

        prop = new Properties();

        String propFilePath = System.getProperty("user.dir") + "/src/test/java/resources/Config.properties";

        File myFile = new File(propFilePath);

        FileInputStream fis = new FileInputStream(myFile);

        prop.load(fis);

        //get browser property
        String browerType = prop.getProperty("BrowserType");

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

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, ITestContext iTestContext) throws IOException {
        //In BeforeMethod , we cannot get IResult objet, it is a null objet, result objet will be filled up after a test execution, so in test listener onTestStart is a place is - after test is initialied, but not finished, and result is filled up with at least test inforations.
        InitializeDriver();

        iTestContext.setAttribute("WebDriver", driver);

        String url = prop.getProperty("URL");

        driver.get(url);

        homepage =  new HomePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult iTestResult) throws IOException {

//        driver.close();
        driver.quit();

    }

    public WebDriver getDriver(){
        return driver;
    }

}
