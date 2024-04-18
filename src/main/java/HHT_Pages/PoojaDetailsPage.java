package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class PoojaDetailsPage {
    public static final Logger log = LogManager.getLogger(PoojaDetailsPage.class.getName());
    WebDriver driver;

    // Constructor
    public PoojaDetailsPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

    public Boolean verifyPoojaDetailsHeader(){
        return driver.findElement(By.xpath("//div[@id='bar']/h1")).isDisplayed();
    }

    public void clickAddPoojaButton(){
        driver.findElement(By.partialLinkText("ADD")).click();
    }

    public void clickViewOption(String PoojaTitle){
        List<WebElement> ViewTitle = driver.findElements(By.xpath("//tr//td[2]"));
        System.out.println(ViewTitle.size());
        for (int X = 0; X<ViewTitle.size(); X++) {
            String Title = ViewTitle.get(X).getText();
            if (Title.equals(PoojaTitle)) {
                int r = X + 2;
                driver.findElement(By.xpath("//tr[" + r + "]/td[6]/a[1]")).click();
                System.out.println("Clicked View for the title:"+ PoojaTitle);
                break;
            }
        }
    }


}
