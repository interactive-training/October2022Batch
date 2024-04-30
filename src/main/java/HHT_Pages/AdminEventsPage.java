package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminEventsPage {
    public static final Logger log = LogManager.getLogger(AdminEventsPage.class.getName());

    WebDriver driver;
    // Constructor
    public AdminEventsPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables
    By addEvent = By.xpath("//a[@href='add_event.php']");

    // Page Methods
    public void clickAddEvents(){
        driver.findElement(addEvent).click();
    }

    public void clickSubmitButton(){
        driver.findElement(By.xpath("//tr[13]/td/input")).click();
        System.out.println("Event Edited");
        log.info("Event Edited");
    }


}
