package pages;

import ita.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class JobSeekersSignUpPage extends BasePage {
    public static final Logger log = LogManager.getLogger(JobSeekersSignUpPage.class);
    WebDriver driver;

    public JobSeekersSignUpPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickSignUp(){
        By signUpBy= By.xpath("//a[@href='register_form.php']/span");
        driver.findElement(signUpBy).click();
    }

//    public void verifyJobSeekersSignUp(){
//        String expectedURL = "https://www.viewcvs.co.uk/register_form.php";
//        String actualURL = driver.getCurrentUrl();
//        Assert.assertEquals(driver.getCurrentUrl(),expectedURL,"Url did not match.");
//    }

    public void getFullName(String fullName){
        By fullNameBy = By.name("name");
        driver.findElement(fullNameBy).sendKeys(fullName);
    }

    public void getEmail(String email){
        By emailBy = By.name("email");
        driver.findElement(emailBy).sendKeys(email);
    }

    public void getPassword(String password){
        By passwordBy = By.name("password");
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void clickNext(){
        By nextBy = By.id("next");
        driver.findElement(nextBy).click();
    }

    public void setIndustry(String industry){
        WebElement elmIndustry = driver.findElement(By.xpath("//select[@name='sector']"));
        Select selectObj = new Select(elmIndustry);
        selectObj.selectByValue(industry);
    }

    public void marketingCheckBox(){
        By marketingBy = By.id("agree-term");
        driver.findElement(marketingBy).click();
    }

    public void clickContinue(){
        By continueBy = By.id("next");
        driver.findElement(continueBy).click();
    }

    public void accountCreatedAlert(){
        By alertBy = By.xpath("//div[@class='greendiv']"); // url =https://www.viewcvs.co.uk/account_created.php
        String actual = driver.findElement(alertBy).getText();
        String expected = "Your account has been created. welcome to Viewcvs.co.uk";
        Assert.assertEquals(actual,expected, "Text does not match.");
        //Assert.assertTrue(driver.findElement(alertBy).isDisplayed());
    }

    public String createAnAccountIsDisplayed(){
        By logInBy = By.xpath("//h2[@class='form-title']"); // same xpath for Please log in sign in page
        return String.valueOf(logInBy);
    }

    public void clickGoToAccount(){
        By accountBy = By.linkText("Go To Your Account");
        driver.findElement(accountBy).click();

        // a[text()='Go To Your Account']
    }
}
