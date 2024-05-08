package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class NewsLetterSubscriberDetailsPage {
    public static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    WebDriver driver;
//    Properties prop;

//    By NLDeleteBy = (By.xpath("//td[text()='1']//following-sibling::td/a[text()='Delete']"));

    // Constructor
    public NewsLetterSubscriberDetailsPage(WebDriver driver){
        //super(driver);
        this.driver = driver;
    }
    public Boolean verifyNewsLetterSubscriberDetailsHeader(){
        return driver.findElement(By.xpath("//h1[text()='News Letter Subscriber Details']")).isDisplayed();
    }
    public void DeleteNewsLetter(String EmailField){
        List<WebElement> emailField = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr//td[3]"));
        System.out.println(emailField.size());

        for (int n = 0; n <= emailField.size(); n++) {
            // Looping each Event Title
            String title = emailField.get(n).getText();
            int r = n + 2; // to pass the matching row for the given event to delete
            if (title.equalsIgnoreCase(EmailField)) {
                // Deleting the event
                driver.findElement(By.xpath("//tbody/tr[ " + r + " ]/td[4]/a")).click();
                break;
            }
        }
//
        }
    }

