package com.ita.util;

//import com.sun.jdi.connect.spi.TransportService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;
import org.testng.annotations.Optional;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverManager {

    public static ThreadLocal<WebDriver>  driversCollection = new ThreadLocal<WebDriver>();

    private WebDriver driver;

    public WebDriver initializeDriverGrid(String browser, String platform, String browserVersion) throws Exception {

        String hubURL = "http://192.168.1.4:4444";

//        DesiredCapabilities capabilities = null;

        if (browser.equalsIgnoreCase("chrome")){

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_context_settings.popups", 0);

//            ChromeOptions chromeoptions = new ChromeOptions();
            //adding chrome options
            ChromeOptions chromeoptions = new ChromeOptions();
            chromeoptions.addArguments("--remote-allow-origins=*");
            //if browser is headless, add healless
//            chromeoptions.addArguments("--headless"); //headless
//            chromeoptions.addArguments("--disable-gpu");

//            chromeoptions.setExperimentalOption("prefs", chromePrefs);

//            capabilities.acceptInsecureCerts();
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);

//            capabilities.setBrowserName(ChromeOptions.CAPABILITY); // This is same as -->  capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//            //but when we use setCapability, it acccepts const paramter

//            capabilities.setPlatform(Platform.WIN10);

            //finally add options to capability

            driver = new RemoteWebDriver(new URL(hubURL),capabilities);

        }
        else if(browser.equalsIgnoreCase("firefox")) {
            //firefox, we have to crate a new profile, Chrome does it by default

//            WebDriverManager.firefoxdriver().setup();
//            System.setProperty("webdriver.gecko.driver", driverPath);


            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette",true);
//            driver= new FirefoxDriver(capabilities);

//            FirefoxOptions options = new FirefoxOptions();
//            options.addPreference("dom.popup_maximum", 0);

//            capabilities.setBrowserName(String.valueOf(Browser.FIREFOX)); // This is same as -->  capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            driver = new RemoteWebDriver(new URL(hubURL),capabilities);


        }


        //add common pramters to driver
        driver.manage().window().maximize();
        //set implicitwai time
//        Integer implicitWaitFrom = Integer.parseInt(prop.getProperty("impilcitTimeInSec", "10"));
//        driver.manage().timeouts().implicitlyWait();


        //add drive to the thread
        driversCollection.set(driver);

        driver.get("https://viewcvs.co.uk");

        return driver;

    }

    public WebDriver initializeDriver(String param_browserType) throws Exception {

        if (param_browserType.equalsIgnoreCase("chrome")){

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver(chromeOptions); //local system , opening chrome, so executed system should have all respetive browser executable and chromedriver setup
        }
        else if (param_browserType.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();

            driver  = new FirefoxDriver(); //firefox to start a new profile for firefox , because firefox not create a new profile by default

        }
        else if (param_browserType.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        if (driver == null){
            throw new Exception("Could not create driver. for browserType : " + param_browserType);
        }


        //add common pramters to driver
        driver.manage().window().maximize();
        //set implicitwai time
//        Integer implicitWaitFrom = Integer.parseInt(prop.getProperty("impilcitTimeInSec", "10"));
//        driver.manage().timeouts().implicitlyWait(10);

        driver.get("https://viewcvs.co.uk");

        //add drive to the thread
        driversCollection.set(driver);

        return driver;

    }

    public static WebDriver getDriver() throws Exception {

        if (driversCollection.get() == null){

            throw new Exception("Browser not created for this thread. Plese call InitializeDriver");

        }

        return driversCollection.get();
    }


}
