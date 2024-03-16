package HHT_Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class EventsPage {
    WebDriver driver;
    // Constructor
    public EventsPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables
    By addEvents = By.xpath("//a[@href='add_event.php']");

    By submitBy = By.xpath("//tr[12]/td/input");
    By eventTitleBy = By.xpath("//tr/td[2]/input");
    By eventTypeBy = By.xpath("//tr[2]/td[2]/input");
    By eventStartDateBy = By.xpath("//tr[3]/td[2]/input");
    By eventEndDateBy = By.xpath("//tr[4]/td[2]/input");
    By eventTimeDuration = By.xpath("//tr[5]/td[2]/input");
    By eventLocationBy = By.xpath("//tr[6]/td[2]/input");

    // Page Methods

    public void clickAddEvents(){
        driver.findElement(addEvents).click();
    }

    public void createEvent(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps();
        // Passing information to the text fields through feature
        driver.findElement(eventTitleBy).sendKeys(data.get(0).get("EventTitle"));
        driver.findElement(eventTypeBy).sendKeys(data.get(0).get("EventType"));
        driver.findElement(eventStartDateBy).sendKeys(data.get(0).get("EventStartDate"));
        driver.findElement(eventEndDateBy).sendKeys(data.get(0).get("EventEndDate"));
        driver.findElement(eventTimeDuration).sendKeys(data.get(0).get("EventTimeDuration"));
        driver.findElement(eventLocationBy).sendKeys(data.get(0).get("EventLocation"));
        // Passing information to the iframe
        WebElement outerIframe = driver.findElement(By.id("article___Frame"));
        driver.switchTo().frame(outerIframe);
        WebElement innerIframe = driver.findElement(By.xpath("//td[@id='xEditingArea']/iframe"));
        driver.switchTo().frame(innerIframe);
        driver.findElement(By.xpath("/html/body")).sendKeys(data.get(0).get("EventContent"));
        driver.switchTo().defaultContent();
        // Passing the path of the pictures
        String Picture1Path = "//Users//ravibabuadari//Desktop//testing//bogi Small.jpeg";
        driver.findElement(By.xpath("//tr[9]/td[2]/input")).sendKeys(Picture1Path);
        driver.findElement(By.xpath("//tr[10]/td[2]/input")).sendKeys(Picture1Path);
    }

    public void clickSubmitButton(){
        driver.findElement(submitBy).click();
        System.out.println("Clicked on submit");
    }


}
