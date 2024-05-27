package HHT_Pages;

import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class CreateEventsPage {
    public static final Logger log = LogManager.getLogger(CreateEventsPage.class.getName());

    WebDriver driver;
    public CreateEventsPage(WebDriver driver){
        this.driver = driver;
    }
    // By Variables
    By submitBy = By.xpath("//tr[12]/td/input");
    By eventTitleBy = By.xpath("//tr/td[2]/input");
    By eventTypeBy = By.xpath("//tr[2]/td[2]/input");
    By eventStartDateBy = By.xpath("//tr[3]/td[2]/input");
    By eventEndDateBy = By.xpath("//tr[4]/td[2]/input");
    By eventTimeDuration = By.xpath("//tr[5]/td[2]/input");
    By eventLocationBy = By.xpath("//tr[6]/td[2]/input");
    By outerFrameBy = By.id("article___Frame");
    By innerFrameBy = By.xpath("//td[@id='xEditingArea']/iframe");
    By eventContentBy = By.xpath("/html/body");
    By firstPictureBy = By.xpath("//tr[9]/td[2]/input");
    By secondPictureBy = By.xpath("//tr[10]/td[2]/input");
    // --------------------------------Create Event at Back-end-------------------------------------------------------------

    public void createEvent(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps();
        // Passing information to the text fields through feature
        driver.findElement(eventTitleBy).sendKeys(data.get(0).get("EventTitle"));
        driver.findElement(eventTypeBy).sendKeys(data.get(0).get("EventType"));
        driver.findElement(eventStartDateBy).sendKeys(data.get(0).get("EventStartDate"));
        driver.findElement(eventTitleBy).click();

        driver.findElement(eventEndDateBy).sendKeys(data.get(0).get("EventEndDate"));
        driver.findElement(eventTitleBy).click();

        driver.findElement(eventTimeDuration).sendKeys(data.get(0).get("EventTimeDuration"));
        driver.findElement(eventLocationBy).sendKeys(data.get(0).get("EventLocation"));
        // Passing information to the iframe
//        WebElement outerIframe = driver.findElement(outerFrameBy);
//        driver.switchTo().frame(outerIframe);
//        WebElement innerIframe = driver.findElement(innerFrameBy);
//        driver.switchTo().frame(innerIframe);
//        driver.findElement(eventContentBy).sendKeys(data.get(0).get("EventContent"));
//        driver.switchTo().defaultContent();


//        Actions action = new Actions(driver);
//        action.moveToElement(outerIframe).moveToElement(innerFrameBy).sendKeys(data.get(0).get("EventContent")).build().perform();

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        WebElement outerIframe = driver.findElement(outerFrameBy);// iframe
//        jse.executeScript(("arguments[0].click();"), outerIframe);
//        //jse.executeScript("document.querySelector(\"iframe[id='article___Frame']\")");
////        WebElement innerIframe = driver.findElement(innerFrameBy);
////        jse.executeScript(("arguments[0].click();"), innerIframe);
//        WebElement eventContent = driver.findElement(eventContentBy);
//        jse.eventContentByxecuteScript(("arguments[0].sendKeys(data.get(0).get(\"EventContent\");"), eventContent);
//

        // Passing the path of the pictures
        String Picture1Path = System.getProperty("user.dir")+ "/src/main/java/resources/Images/bogi Small 17.27.27.jpeg";
        driver.findElement(firstPictureBy).sendKeys(Picture1Path);
        driver.findElement(secondPictureBy).sendKeys(Picture1Path);
    }

    public void clickSubmitButton(){
        driver.findElement(submitBy).click();
        log.info("Clicked on Submit button");
        System.out.println("Clicked on submit");
        log.info("Clicked on Submit");
    }

    public String verifyIncorrectDate(){return driver.findElement(By.xpath("//tr[4]/td[2]/input")).getText();}

}
