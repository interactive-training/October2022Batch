package ITATest.tests;

import ITATest.BaseTest.BaseTest;
import ITATest.pages.Credentials;
import ITATest.pages.JobsAndApplications;
import ITATest.pages.Recruiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyRecruiters extends BaseTest {

    WebDriver driver;

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


    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void VerifyJObsAndApplicationsPage(){


        Recruiters recruiters = new Recruiters(driver);
        recruiters.clickRecruitersLInk();

        //click on recruiters
//        driver.findElement(By.linkText("Recruiters")).click();


        //enter credentials
        Credentials credentials = new Credentials(driver);
        credentials.login("born.testers@gmail.com", "October2022" );
        //verify if user is on the recuriter's page
        String expected_Title = "Recruiter Dashboard - viewcvs.co.uk";
        Assert.assertEquals(credentials.getBrowserTitle(), expected_Title,"Both titles are not matching"); //junit - (expected, actual)

//        ============================= Recruiters =================



        //verify email id is displyed as we passed
        String expectedEmail = "born.testers@gmail.com";
        String actualEmail = recruiters.getRecruitersEmailAddr();
        Assert.assertEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");


        //========================= Jobs and Applications =====================
        //jobs and verification link
        JobsAndApplications jobsNApp = new JobsAndApplications(driver);
        jobsNApp.clickJobsAndApplicationMainMenu();
        //verify manager's page appearing
        String expected_value = "Manage Jobs";
        String actualValue = jobsNApp.getManageJobsText();
        Assert.assertEquals(actualValue, expected_value);


//        Thread.sleep(2000);

        driver.close();


    }

    @Test
    public void VerifyRecruitersLogin_Invalid_Username_InValid_password(){


        Recruiters recruiters = new Recruiters(driver);
        recruiters.clickRecruitersLInk();

        //enter credentials
        Credentials credentials = new Credentials(driver);
        credentials.login("born.testers@gmsdfsfdfail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = credentials.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for wrong username/password not displayed correctly"); //junit - (expected, actual)


        driver.close();

    }

    @Test
    public void VerifyRecruitersLogin_Valid_Username_InValid_password(){



        Recruiters recruiters = new Recruiters(driver);
        recruiters.clickRecruitersLInk();

        //enter credentials
        Credentials credentials = new Credentials(driver);
        credentials.login("born.testers@gmail.com", "sdffdsfadfa" );

        String expectedMsg = "Invalid Login Credentials.";
        String actualMsg = credentials.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg,"Error message for valid username, invalid password");


        driver.close();

    }


}
