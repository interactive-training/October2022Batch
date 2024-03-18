package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ViewEventsPage {
    public static final Logger log = LogManager.getLogger(ViewEventsPage.class.getName());

    WebDriver driver;

    public ViewEventsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void viewEvent(String EventTitle){
        List<WebElement> titleElements = driver.findElements(By.xpath("//tr/td[2]"));
        System.out.println(titleElements.size());

        for (int n = 0; n < titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();

            if (title.equalsIgnoreCase(EventTitle)) {
                int r = n + 1; // to pass the matching row for the given event
                // Clicking on the Event Title
                //driver.findElement(By.xpath("//tr[" + r + " ]/td[4]/a[1]")).click();
                WebElement element = driver.findElement(By.xpath("//tr[" + r + " ]/td[4]/a[1]"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
                break;
            }
        }
    }

    public String verifyEventHeading(){
        return driver.findElement(By.xpath("//div[@id='bar']/h1")).getText();
    }
}
