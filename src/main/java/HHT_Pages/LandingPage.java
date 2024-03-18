package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {
    public static final Logger log = LogManager.getLogger(LandingPage.class.getName());

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
    public void clickEventsThenCalendar() {
        Actions action = new Actions(driver);// Initiating the Actions class for mouse hover(drop-down)
        WebElement Home_Menu = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Events']"));    //Finding the element with drop-down
        action.moveToElement(Home_Menu).perform(); // Hovering over the Training drop-down
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement events = driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]/li[1]/a"));  // By.xpath("(//a[@href='events_web.php'])[1]")      Finding the Events
        action.moveToElement(events).click().perform();
    }
}
