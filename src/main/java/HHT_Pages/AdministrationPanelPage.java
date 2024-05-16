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

    By NewsLetterBy = By.xpath("//div[@id='wrapper']/nav/ul/li[6]/a");
    By DonationsBY = By.linkText("DONATIONS");

    By MembersBy = (By.xpath("//div[@id='wrapper']/nav/ul/li[3]/a"));

    By OrdersBy = (By.xpath("//div[@id='wrapper']/nav/ul/li[5]/a"));

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
        WebElement cms = driver.findElement(CMSBy);
        actions.moveToElement(cms).perform();
        WebElement news = driver.findElement(By.linkText("NEWS"));
        news.click();
    }
    public void clickCMSthenPoojas(){
        Actions action = new Actions(driver);
        WebElement CMS_elm = driver.findElement(CMSBy);
        action.moveToElement(CMS_elm).perform();
        System.out.println("CMS dropdown");
        driver.findElement(By.linkText("POOJAS")).click();
        System.out.println("clicked on Poojas");
    }
    public void clickNewsLetter(){
        WebElement NL = driver.findElement(NewsLetterBy);
        NL.click();
        System.out.println("Clicked on NewsLetter");

    }
    public void clickDonations(){
        Actions action = new Actions(driver);
        WebElement CMS_elm = driver.findElement(CMSBy);
        action.moveToElement(CMS_elm).perform();
        System.out.println("CMS dropdown");
        driver.findElement(DonationsBY).click();
        System.out.println("clicked on DONATIONS");

    }

    public void clickMembers(){
        WebElement membersMenu = driver.findElement(MembersBy);
        membersMenu.click();
    }
    public void clickOrders(){
        WebElement ordersMenu = driver.findElement(OrdersBy);
        ordersMenu.click();
    }


}
//a[@href='index.php']