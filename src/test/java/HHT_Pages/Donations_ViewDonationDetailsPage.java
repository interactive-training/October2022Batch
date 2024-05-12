package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Donations_ViewDonationDetailsPage {
    public static final Logger log = LogManager.getLogger(News_ViewNewsDetailsPage.class.getName());
    WebDriver driver;
    By ViewDonationHeaderBY = By.xpath("(//div[@id='bar']/h1)");

    public Donations_ViewDonationDetailsPage(WebDriver driver){
        this.driver = driver;
    }

        public Boolean verifyViewDonationDetailsHeader(){
        return driver.findElement(ViewDonationHeaderBY).isDisplayed();
    }

}
