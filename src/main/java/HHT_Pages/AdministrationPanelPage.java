package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdministrationPanelPage {
    WebDriver driver;
    // Constructor
    public AdministrationPanelPage(WebDriver driver) {

        this.driver = driver;
    }

    // By variables
    By CMSbY = By.linkText("CMS");
    By EventsBy = By.linkText("EVENTS");

    //Page Methods

    public void clickCMSthenEvents(){
        Actions action = new Actions(driver);                // Initiating the Actions class for mouse hover(drop-down)
        WebElement CMS_Menu = driver.findElement(CMSbY);    //Finding the element with drop-down
        action.moveToElement(CMS_Menu).perform();          // Hovering over the Training drop-down
        WebElement events = driver.findElement(EventsBy);  // Finding the Events
        events.click();
    }
}
