package HHT_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewEventsPage {
    WebDriver driver;

    public ViewEventsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void viewEvent(String EventTitle){
        List<WebElement> titleElements = driver.findElements(By.xpath("//tr/td[2]"));
        System.out.println(titleElements.size());

        for (int n = 0; n <= titleElements.size(); n++) {
            // Looping each Event Title
            String title = titleElements.get(n).getText();
            int r = n + 1; // to pass the matching row for the given event
            if (title.equalsIgnoreCase(EventTitle)) {
                // Clicking on the Event Title
                driver.findElement(By.xpath("//tr[" + r + " ]/td[4]/a[1]")).click();
                break;
            }
        }
    }

    public String verifyEventHeading(){
        return driver.findElement(By.xpath("//div[@id='bar']/h1")).getText();
    }
}
