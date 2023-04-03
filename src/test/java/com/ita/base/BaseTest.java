package com.ita.base;

import com.ita.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    //why protected ? it will work with public as well, but just do not throught out anyone should use this driver objet,
    // protected means you are allowing those classes to use it who extends this class, not just anyone by creating a new objet of it.

    protected HomePage homepage;

    @BeforeMethod
    public void InitializeDriver(){

        //start browser

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        //maximizze
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.viewcvs.co.uk/index.php");

        this.homepage = new HomePage(driver);

    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
