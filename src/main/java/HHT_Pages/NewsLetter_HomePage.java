package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsLetter_HomePage {

        public static final Logger log = LogManager.getLogger(NewsLetter_HomePage.class.getName());

        WebDriver driver;
        public NewsLetter_HomePage(WebDriver driver) {
            this.driver = driver;
        }
        By EmailidBy = (By.xpath("//input[@id='emailaddress']"));
        By NewsLetterSignupBy = (By.xpath("//input[@name='save']"));
        public void Newsletteremail(String Emailid) {
            driver.findElement(EmailidBy).sendKeys(Emailid);
}
public void NewsLetterSignup(){
    driver.findElement(NewsLetterSignupBy).click();

}
    }
