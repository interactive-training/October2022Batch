package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Donations_EditDonationsPage {
    public static final Logger log = LogManager.getLogger(Donations_EditDonationsPage.class.getName());
    WebDriver driver;
    By SubmitBy = By.xpath("//input[@type='submit']");
    By MessageBy = By.xpath("//div[@class='error_msg']");

    By EditFieldBy = By.xpath("//table//tbody[1]//tr[4]//td[2]//input[@name='price1']");

    public Donations_EditDonationsPage (WebDriver driver){
        this.driver = driver;
    }
// By variables

    // Methods
    public String verifyEditDonationsDetailsHeader(){
        return driver.findElement(By.xpath("(//div[@id='bar'])")).getText();
    }
    public void editDonationFields(String EditField,String EditInfo)  {
        if (EditField.equalsIgnoreCase("Donation Amount in £")) {
            driver.findElement(EditFieldBy).clear();
            driver.findElement(EditFieldBy).sendKeys(EditInfo);
        }
    }
    public void DonationSubmitButton(){
        driver.findElement(SubmitBy).click();
    }
    public boolean verifySuccessfullMsg(){
        return driver.findElement(MessageBy).isDisplayed();

    }

}
