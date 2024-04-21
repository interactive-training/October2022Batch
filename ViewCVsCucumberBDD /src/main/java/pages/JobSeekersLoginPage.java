package pages;
import ita.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobSeekersLoginPage extends BasePage {
    public static final Logger log = LogManager.getLogger(JobSeekersLoginPage.class);
    WebDriver driver;
    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By signInButtonJs = By.xpath("//form[@id='signup-form']");
    By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");
    By myProfileBy = By.xpath("//div[text()='My Profile']");
    public JobSeekersLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signInButtonJs).submit();
        System.out.println("Logged in successfully");
    }

    // verify the My Profile Page
    public void isMyProfilePageDisplayed(){
        Assert.assertTrue(driver.findElement(myProfileBy).isDisplayed(),"Profile page is not loaded");
        System.out.println("My Profile page is loaded.");
    }

    public void addWorkExperience() {
        By workButton = By.xpath("//h1[text()='Work Experience ']/..//a/button");
        driver.findElement(workButton).click();
    }
    // Add Experience Page is clicked
        public void getAddExperiencePage(){
        //driver.findElement(workExperienceHeaderBy).isDisplayed();
        Assert.assertTrue(driver.findElement(workExperienceHeaderBy).isDisplayed(), "Work experience page has not loaded property.");
        System.out.println("Add Experience page is loaded.");
    }
}




