package HHT_Pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventsPage {
    WebDriver driver;

    public EventsPage(WebDriver driver){
        this.driver = driver;
    }
    // By variables
    By eventsTitleElementsBy = By.xpath("(//div[@class='events_main'])/p[3]");

    //Page Methods
    public String eventsPageHeading(){
      return   driver.findElement(By.xpath("(//div[@class='container'])[4]/h2")).getText();
    }

    public void userClicksMoreInfo(String EventTitle, String option) {
        List<WebElement> titleElements = driver.findElements(eventsTitleElementsBy);
        System.out.println(titleElements.size());

        // checking if the event actually exists before entering the loop
        for (int n = 0; n < titleElements.size(); n++)
        {
            // Looping each Event Title
            String title = titleElements.get(n).getText();

            if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("view")))
            {
                int r = n + 1; // to pass the matching row for the given event
                // Clicking on the Event Title
                driver.findElement(By.xpath("(//p[@class='eventsimg'])[\" + r + \"]/a")).click();
                break;
            }
            else if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("delete")))
            {
                System.out.println("There is a duplicate event.");
                break;
            }
        }
        //System.out.println("Event is not present in Event's Page.");
    }
    public String verifyEventTitleOnPage(){
        return driver.findElement(By.xpath("//div[@class='gurumid']/div[2]/h4")).getText();
    }



}
