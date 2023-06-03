package ita;
import org.testng.annotations.Test;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.JobSeekersLoginPage;

import java.io.*;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homepage; // Are we declaring the variable or object here?
    public Properties prop;  // declared here so we can call it from any method.


    @BeforeMethod
    public void InitializeDriver() throws IOException {
        //read properties file
        prop = new Properties(); // creating a prop object;  Properties prop = new Properties(); not this way because we want to acll the object from all methods so declared in class.

        // declaring the variable(propFilePath) and assigning the location of the properties to it.
        String propFilePath= System.getProperty("user.dir")+"/src/test/java/resources/config.properties";

        // creating the object(fis) in the FileInputStream as 'object.load' accepts through this class.
        FileInputStream fis = new FileInputStream(new File(propFilePath)); // converting the string(propFilePath to a file

        //loads the contents of the properties from fis object; once loaded we can read the value of the key when called.

            prop.load(fis);  // have this import java.io.*; for load otherwise error


        //get browser property
        String browserType = prop.getProperty("BrowserType");

        if(browserType.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
        }
        else if (browserType.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        // maximise browser window
        driver.manage().window().maximize();

        //set implicitwait time

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImplicityWaitTimeInSec","10"))));

        //get url
        //prop.getProperty("URL");                // why not this way
        driver.get("https://www.viewcvs.co.uk/index.php");

        this.homepage = new HomePage(driver);  // explain this please
        //homepage =  new Homepage(driver);   // in new BaseTest this is changed.
    }

    @AfterMethod
    public void TearDown(){driver.quit();}     //TearDown is just a chosen method name isn't it?

    public WebDriver getDriver() {return driver;}  // explain this please

}
