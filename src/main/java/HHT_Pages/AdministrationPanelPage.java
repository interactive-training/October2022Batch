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
    By CMSBy = By.linkText("CMS");
    By EventsBy = By.linkText("EVENTS");

    //Page Methods

    public Boolean welcomeLogin() {
        return driver.findElement(By.xpath("//span[@class='welcome']")).isDisplayed();
    }


    public void clickCMSthenEvents(){
        Actions action = new Actions(driver);                // Initiating the Actions class for mouse hover(drop-down)
        WebElement CMS_Menu = driver.findElement(CMSBy);    //Finding the element with drop-down
        action.moveToElement(CMS_Menu).perform();          // Hovering over the Training drop-down
        WebElement events = driver.findElement(EventsBy);  // Finding the Events
        events.click();
    }
    public void clickCMSthenNews(){
        Actions actions = new Actions(driver);
        WebElement cms = driver.findElement(By.linkText("CMS"));
        actions.moveToElement(cms).perform();
        WebElement news = driver.findElement(By.linkText("NEWS"));
        news.click();
    }
    public void clickCMSthenPoojas(){
        Actions action = new Actions(driver);
        WebElement CMS_elm = driver.findElement(By.linkText("CMS"));
        action.moveToElement(CMS_elm).perform();
        System.out.println("CMS dropdown");
        driver.findElement(By.linkText("POOJAS")).click();
        System.out.println("clicked on Poojas");
    }

}
//a[@href='index.php']