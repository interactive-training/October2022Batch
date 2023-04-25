package com.ita.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitersPage extends BasePage {

    WebDriver driver;

    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");

    By recruitersEmail = By.xpath("(//div[@class='right'][1]/p/strong[2])[1]");

    public RecruitersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public String  getRecruitersEmailAddr(){

        waitForElementToAppear(driver.findElement(recruitersEmail));

       return driver.findElement(recruitersEmail).getText();

    }

    public void loginRecruiter(String email, String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(button).click();
    }

    By errorMsgLocator = By.xpath("//div[@id='errorval']/b");
    public String getErrorMsg(){
        return driver.findElement(errorMsgLocator).getText();
    }

    public void clickRegisterLink(){

        driver.findElement(By.linkText("Register")).click();

    }


    public void enterFirstName(String firstname){
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
    }

}
