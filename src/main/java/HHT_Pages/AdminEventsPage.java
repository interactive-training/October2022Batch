package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminEventsPage {
    WebDriver driver;
    // Constructor
    public AdminEventsPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables
    By addEvent = By.xpath("//a[@href='add_event.php']");
//    By editEvent =
//            By viewEvent =
//            By deleteEvent =


    // Page Methods
    public void clickAddEvents(){
        driver.findElement(addEvent).click();
    }

    public void clickSubmitButton(){
        driver.findElement(By.xpath("//tr[13]/td/input")).click();
        System.out.println("Event Edited");    }


}
