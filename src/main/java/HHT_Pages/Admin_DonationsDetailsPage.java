package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Admin_DonationsDetailsPage {
    public static final Logger log = LogManager.getLogger(Admin_DonationsDetailsPage.class.getName());

    WebDriver driver;
    public Admin_DonationsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void viewDonations(String DonationTitle){
        List<WebElement> ViewTitle = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr//td[2]"));
        System.out.println(ViewTitle.size());
        for (int X = 0; X<ViewTitle.size(); X++) {
            String Title = ViewTitle.get(X).getText();
            if (Title.equals(DonationTitle)) {
                int r = X + 2;
                driver.findElement(By.xpath("//tr[" + r + "]//td[4]//a[1]")).click();
                break;
            }
        }
    }
    public void editDonations(String DonationTitle ){
        List<WebElement> EditElements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println(EditElements.size());
        log.info("Donation's Edit element size :" + EditElements.size());

        for (int i1 = 0; i1 <= EditElements.size(); i1++) {
            String Title = EditElements.get(i1).getText();

            if (Title.equals(DonationTitle)) {
                int r1 = i1 + 2;
                driver.findElement(By.xpath("//tr[" + r1 + "]/td[4]/a[2]")).click();
                break;
            }
        }
    }

    }



