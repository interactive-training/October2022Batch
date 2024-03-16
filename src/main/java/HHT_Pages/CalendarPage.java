package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CalendarPage {
    WebDriver driver;

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickEventsThenCalendar() {
        Actions action = new Actions(driver);// Initiating the Actions class for mouse hover(drop-down)
        WebElement Home_Menu = driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle'][normalize-space()='Events']"));    //Finding the element with drop-down
        action.moveToElement(Home_Menu).perform(); // Hovering over the Training drop-down
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement events = driver.findElement(By.xpath("(//ul[@class='dropdown-menu'])[2]/li[1]/a"));  // By.xpath("(//a[@href='events_web.php'])[1]")      Finding the Events
        action.moveToElement(events).click().perform();
    }

    public boolean verifyCalendarPage() {
        return driver.findElement(By.xpath("(//div[@class='container'])[4]/h2")).isDisplayed();
    }

    public void userClicksOnDetails(String EventTitle, String option){
        List<WebElement> titleElements = driver.findElements(By.xpath("//tbody/tr/td[3]/div/p/a"));
        System.out.println(titleElements.size());

        for (int n = 0; n < titleElements.size(); n++)
        {   // Looping each Event Title
            String title = titleElements.get(n).getText();

            if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("view")))
            {
                int r = n + 1; // to pass the matching row for the given event
                // Clicking on the Event Title
                driver.findElement(By.xpath("//tbody/tr[ " + r + " ]/td[3]/div/p/a")).click();
                break;
            }
            else if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("delete")))
            {
                System.out.println("There is a duplicate event.");
                break;
            }
        }
        //System.out.println("Event is not present in the Calendar.");
    }
}
