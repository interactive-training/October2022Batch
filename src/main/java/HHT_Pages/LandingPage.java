package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables
    By langinPageMenuBy = By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Events']");

    By eventsOptionBy = By.xpath("(//ul[@class='dropdown-menu'])[2]/li[2]/a");
    //Page Methods

    public void userChoosesEventsInEventsDropDown(){
        Actions action = new Actions(driver);// Initiating the Actions class for mouse hover(drop-down)
        WebElement eventsMenu = driver.findElement(langinPageMenuBy);    //Finding the element with drop-down
        action.moveToElement(eventsMenu).perform(); // Hovering over the Events drop-down
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement eventsOption = driver.findElement(eventsOptionBy);
        action.moveToElement(eventsOption).click().perform();
    }
}
