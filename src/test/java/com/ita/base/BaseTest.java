package com.ita.base;

import com.aventstack.extentreports.utils.FileUtil;
import com.github.javafaker.Faker;
import com.ita.pages.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;

import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    //why protected ? it will work with public as well, but just do not throught out anyone should use this driver objet,
    // protected means you are allowing those classes to use it who extends this class, not just anyone by creating a new objet of it.

    protected HomePage homepage;

    static Properties prop; //because I may use this property value from anywhere in the project, improvement -> cretea class and creae one method for one property. ?? ==> homework

    @BeforeMethod
    public void InitializeDriver() throws IOException {

        //read properties file

        prop = new Properties();

        String propFilePath = System.getProperty("user.dir") + "/src/test/java/com/ita/resources/Config.properties";

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


        String url = prop.getProperty("URL");

        driver.get(url);

        homepage =  new HomePage(driver);

    }

    public String getScreenShot() throws IOException {

        Faker faker = Faker.instance();

        TakesScreenshot sc = (TakesScreenshot)driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        String sourcePath;
        sourcePath = System.getProperty("user.dir") + "//Reports//" + faker.name().firstName() + ".png";
        File target = new File(sourcePath);
        FileUtils.copyFile(source,target);
        return sourcePath;

    }


    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
