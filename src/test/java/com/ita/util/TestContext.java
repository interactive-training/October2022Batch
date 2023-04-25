package com.ita.util;

import com.ita.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    public RecruitersPage getRecruitersPage(){
        if (recruitersPage == null) {
            recruitersPage = new RecruitersPage(driver);
        }

        return recruitersPage;
    }


//    public     private WorkExperiencePage workExpPage;  -- homework




    public WebDriver initializeDriver() throws IOException {

        //read properties file

        prop = new Properties();

        String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";

        File myFile = new File(propFilePath);

        FileInputStream fis = new FileInputStream(myFile);

        prop.load(fis);

        //get browser property
        String browserType = prop.getProperty("browser");

        System.out.println("browser type from command prompt ******** : " + System.getProperty("command.browser"));

        // Override browser from command prompt
        String brwoserTypeFromCommandPrompt = System.getProperty("command.browser");

        if (brwoserTypeFromCommandPrompt != null) {
            browserType = brwoserTypeFromCommandPrompt;
        }

        if (browserType.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        //maximizze
        driver.manage().window().maximize();

        //set implicitwai time

        Integer implicitWaitFrom = Integer.parseInt(prop.getProperty("impilcitTimeInSec", "10"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitFrom));


        //navigate to the base URL

//        driver.get("https://www.viewcvs.co.uk/index.php");
        driver.get(prop.getProperty("url"));

        //add this driver to the list



        return driver;
    }

    public WebDriver getDriver() throws IOException {
        if (driver == null) {
            WebDriver d = initializeDriver();
            webDriverObjects.put(Thread.currentThread().getId(), d);
            return webDriverObjects.get(Thread.currentThread().getId());

        } else
            return webDriverObjects.get(Thread.currentThread().getId());
    }

}