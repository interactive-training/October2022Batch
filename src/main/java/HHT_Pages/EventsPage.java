package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class EventsPage {
    public static final Logger log = LogManager.getLogger(EventsPage.class.getName());

    WebDriver driver;

    public EventsPage(WebDriver driver){
        this.driver = driver;
    }
    // By variables
    By eventsTitleElementsBy = By.xpath("(//div[@class='events_main'])/p[3]");

    By numberOfTitlesInEvents = By.xpath("//p[@class='quote-author']");

    //Page Methods
    public String eventsPageHeading(){
      return   driver.findElement(By.xpath("(//div[@class='container'])[4]/h2")).getText();
    }

    public void userClicksMoreInfo(String EventTitle, String option) {
        List<WebElement> titleElements = driver.findElements(eventsTitleElementsBy);
        System.out.println(titleElements.size());
        log.info("Number of Events:"+ titleElements.size());

        // checking if the event actually exists before entering the loop
        for (int n = 0; n < titleElements.size(); n++)
        {
            // Looping each Event Title
            String title = titleElements.get(n).getText();

            if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("view")))
            {
                int r = n + 1; // to pass the matching row for the given event
                // Clicking on the Event Title
                WebElement element = driver.findElement(By.xpath("(//p[@class='eventsimg'])[" + r + "]/a"));

                Actions actions = new Actions(driver);

                actions.moveToElement(element).click().perform();
                //driver.findElement(By.xpath("(//p[@class='eventsimg'])[" + r + "]/a")).click();
                break;
            }
            else if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("delete")))
            {
                log.trace("There is a duplicate event.");
                System.out.println("There is a duplicate event.");
                break;
            }
        }
        //System.out.println("Event is not present in Event's Page.");
    }
    public String verifyEventTitleOnPage(){
        return driver.findElement(By.xpath("//div[@class='gurumid']/div[2]/h4")).getText();
    }
    public List<WebElement> getNumberofTitlesInEvents(){
        return driver.findElements(numberOfTitlesInEvents);
    }

}
