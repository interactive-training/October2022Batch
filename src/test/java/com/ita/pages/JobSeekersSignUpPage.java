package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekersSignUpPage extends BasePage {
    WebDriver driver;

    public JobSeekersSignUpPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
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

    public String accountCreatedAlert(){
        return driver.findElement(By.xpath("//div[@class='greendiv']")).getText();
        //Assert.assertTrue(driver.findElement(alertBy).isDisplayed());
    }

    public String headerText(){
        return driver.findElement(By.xpath("//h2[@class='form-title']")).getText(); // same xpath for Please log in sign in page
    }

    public void clickGoToAccount(){
        By accountBy = By.linkText("Go To Your Account");
        driver.findElement(accountBy).click();

        // a[text()='Go To Your Account']
    }
}


