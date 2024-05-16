package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MembersDetailsPage {
    public static final Logger log = LogManager.getLogger(MembersDetailsPage.class.getName());

    WebDriver driver;
    public MembersDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    // By Variables
    public Boolean verifyMembersDetailsHeader(){
        return driver.findElement(By.xpath("//h1[text()='Pooja Details']")).isDisplayed();
    }



}
