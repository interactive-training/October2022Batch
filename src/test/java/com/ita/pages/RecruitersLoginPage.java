package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitersLoginPage extends BasePage {

    WebDriver driver;

    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");

    By recruitersEmail = By.xpath("(//div[@class='right'][1]/p/strong[2])[1]");

    public RecruitersLoginPage(WebDriver driver) {
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

}
