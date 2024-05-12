package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalendarPage {
    public static final Logger log = LogManager.getLogger(CalendarPage.class.getName());
    WebDriver driver;

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
    }

    //By variables
    By numberOfTitlesInCalendar = By.xpath("//tbody/tr/td[3]/div/p/a");

    public boolean verifyCalendarPage() {
        return driver.findElement(By.xpath("(//div[@class='container'])[4]/h2")).isDisplayed();
    }

    public void userClicksOnDetails(String EventTitle, String option) throws InterruptedException {
        List<WebElement> titleElements = driver.findElements(By.xpath("//tbody/tr/td[3]/div/p/a"));
        System.out.println(titleElements.size());

        for (int n = 0; n < titleElements.size(); n++)
        {   // Looping each Event Title
            String title = titleElements.get(n).getText();
            int r = n + 1; // to pass the matching row for the given event
            if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("view")))
            {
                // Clicking on the Event Title
                // Element not clickable at point exception:</a> is not clickable at point (519, 653)
                //driver.findElement(By.xpath("(//tr)[ " + r + " ]/td[3]/div/p/a")).click();     //(//tr)["+r+"]/td[4]/p/a

                // Element not clickable at point exception:did not work with Actions class
//                WebElement element = driver.findElement(By.xpath("(//tr)[" + r + "]/td[4]/p/a"));
//                Actions actions = new Actions(driver);
//                actions.moveToElement(element).click().perform();

                WebElement element = driver.findElement(By.xpath("//tr[" + r + "]/td[4]/p/a"));
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].scrollIntoView()", element);
                element.click();

                break;
            }
            else if (title.equalsIgnoreCase(EventTitle) && (option.equalsIgnoreCase("delete"))) {
                log.info("There is a duplicate event.");
                System.out.println("There is a duplicate event.");
                break;
            }
        }
        //System.out.println("Event is not present in the Calendar.");
    }
    public List<WebElement> getNumberofTitlesInCalendar(){
        return driver.findElements(numberOfTitlesInCalendar);
    }
}
