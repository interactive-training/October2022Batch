package Utililities;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

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

    // Page variables
    private HomePage homePage;

    private JobSeekersSignUpPage jobSeekersSignUpPage;
    private JobSeekersLoginPage jobSeekersLoginPage;
    private JobSeekersWorkExperiencePage jobSeekersWorkExperiencePage;
    private JobseekersEducationPage jobSeekersEduPage;
    private JobSeekersProfileOtherFieldsPage jobSeekersProfileOtherPage;
    private RecruitersPostAJobPage recruitersPostAJobPage;

    private JobsAndApplicationsPage jobsAndApplicationsPage;
    String jobTitle;

    // methods for creating a new driver or passing the previous one to the next page
    public HomePage getHomepage(){             // it will return the HomePage class
        if(homePage == null){
            homePage = new HomePage(driver);  // if null creates new; without this line if you say return Homepage then the very first time homepage is called it will throw a nullpointer exception as nothing created.
        }                                    // otherwise exit if and return homepage
        return homePage;                   // you can write else return homePage too( same logic)
    }

    public JobSeekersSignUpPage getJobSeekersSignUpPage(){
        if (jobSeekersSignUpPage == null){
            jobSeekersSignUpPage = new JobSeekersSignUpPage(driver);
        }
        return jobSeekersSignUpPage;
    }

    public JobSeekersLoginPage getJobSeekersLoginPage() {
        if (jobSeekersLoginPage == null){
            jobSeekersLoginPage = new JobSeekersLoginPage(driver);
        }
        return jobSeekersLoginPage;
    }
    public JobSeekersProfileOtherFieldsPage getJobSeekersProfileOtherFieldsPage() {
        if (jobSeekersProfileOtherPage == null){
            jobSeekersProfileOtherPage = new JobSeekersProfileOtherFieldsPage(driver);
        }
        return jobSeekersProfileOtherPage;
    }

    public JobSeekersWorkExperiencePage getJobseekersWorkExperiencePage(){
        if (jobSeekersWorkExperiencePage == null){
            jobSeekersWorkExperiencePage = new JobSeekersWorkExperiencePage(driver);
        }
        return jobSeekersWorkExperiencePage;
    }

    public  JobseekersEducationPage getJobseekersEduPage(){
        if (jobSeekersEduPage == null){
            jobSeekersEduPage = new JobseekersEducationPage(driver);
        }
        return jobSeekersEduPage;
    }
    public  RecruitersPostAJobPage getRecruitersPostAJobPage(){
        if (recruitersPostAJobPage == null){
            recruitersPostAJobPage = new RecruitersPostAJobPage(driver);
        }
        return recruitersPostAJobPage;
    }

    public  JobsAndApplicationsPage getJobsAndApplicationsPage(){
        if (jobsAndApplicationsPage == null){
            jobsAndApplicationsPage = new JobsAndApplicationsPage(driver);
        }
        return jobsAndApplicationsPage;
    }

    // As there is no BaseTest initialising comes here

    public WebDriver initializeDriver() throws IOException {
        //read properties file
        prop = new Properties(); // creating a prop object;  Properties prop = new Properties(); not this way because we want to acll the object from all methods so declared in class.

        // declaring the variable(propFilePath) and assigning the location of the properties to it.
        String propFilePath= System.getProperty("user.dir")+"/src/test/java/resources/config.properties";

        File myFile = new File(propFilePath);  // passing the variable to myFile object
        // creating the object(fis) in the FileInputStream as 'object.load' accepts through this class.
        FileInputStream fis = new FileInputStream(myFile); // converting the string(propFilePath to a file

        //loads the contents of the properties from fis object; once loaded we can read the value of the key when called.

        prop.load(fis);  // have this import java.io.*; for load otherwise error


        //get browser property
        String browserType = prop.getProperty("BrowserType");

        // Override browser from command prompt
        String browserTypeFromCommandPrompt = System.getProperty("command.browser");
        System.out.println("BrowserType from command prompt ******** :" + System.getProperty("command.browser"));

        if (browserTypeFromCommandPrompt != null) {
            browserType = browserTypeFromCommandPrompt;
        }

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            //driver = new ChromeDriver();
        }
        else if (browserType.equalsIgnoreCase("firefox")) {

           // WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("edge")) {

           // WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        // maximise browser window
        driver.manage().window().maximize();

        //set implicitwait time
        //prop.getProperty("ImplicitTimeInSec"); // why not this way
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImplicityWaitTimeInSec","10"))));

        //get url
        //prop.getProperty("URL");                // why not this way from BaseTest
        //driver.get("https://www.viewcvs.co.uk/index.php");

        //add this driver to the list
        String r = prop.getProperty("URL");
        return driver;         // we are returning driver here and when each page is loaded it checks null or passed on from previous
    }

    public WebDriver getDriver() throws IOException {             //?
        if (driver == null) {
            WebDriver d = initializeDriver();
            webDriverObjects.put(Thread.currentThread().getId(), d);
            return webDriverObjects.get(Thread.currentThread().getId());

        } else
            return webDriverObjects.get(Thread.currentThread().getId());
    }


    //storing values for verification and to call from other steps
    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    } // sets the value after passing value from the step

    public String getJobTitle(){return this.jobTitle;} // returns the above job title

}

