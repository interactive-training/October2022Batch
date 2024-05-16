package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DonationsPage {
    public static final Logger log = LogManager.getLogger(DonationsPage.class.getName());

    WebDriver driver;
    public DonationsPage(WebDriver driver) {
        this.driver = driver;
    }
    // By variables

    //Page Methods
    public void clicksOnDonateForTitle(String Donations){
        List<WebElement> DonationType = driver.findElements(By.xpath("//tr//td[2]//p"));
        System.out.println(DonationType.size());
        log.info("Number of Donation Titles:" + DonationType.size());
        for (int n = 0; n<DonationType.size(); n++) {
            String Title = DonationType.get(n).getText();
            if (Title.equalsIgnoreCase(Donations)) {
                int r = n + 1;
                driver.findElement(By.xpath("(//tr[" + r + "]//td[3]//a)")).click();
                break;
            }
        }
    }
    public Boolean verifyDonationsHeader(){
        return driver.findElement(By.xpath("//h2[text()='Donations']")).isDisplayed();
    }

}
