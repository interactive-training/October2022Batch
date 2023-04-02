package ITATest.pages;

import ITATest.CommonComponents.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Recruiters extends CommonMethods {

    WebDriver driver;

    By linkText = By.linkText("Recruiters");
    By recruitersEmail = By.xpath("(//div[@class='right'][1]/p/strong[2])[1]");

    public Recruiters(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public void clickRecruitersLInk(){
        driver.findElement(linkText).click();

    }

    public String  getRecruitersEmailAddr(){

        waitForElementoAppear(driver.findElement(recruitersEmail));

       return driver.findElement(recruitersEmail).getText();

    }



}
