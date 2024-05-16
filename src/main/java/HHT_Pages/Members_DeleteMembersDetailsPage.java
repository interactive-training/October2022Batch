package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Members_DeleteMembersDetailsPage {

    public static final Logger log = LogManager.getLogger(Members_DeleteMembersDetailsPage.class.getName());

    WebDriver driver;

    public Members_DeleteMembersDetailsPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void deleteMembers(String MemberName)  {
        List<WebElement> deleteElements = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr//td[2]"));
        System.out.println(deleteElements.size());
        log.info("Number of Members for Deletion:" + deleteElements.size());
        for (int d = 0; d <= deleteElements.size(); d++)
        {
            String deleteValue = deleteElements.get(d).getText();
            int dm = d + 2;
            if (deleteValue.equals(MemberName))
            {
                // Deleting Members
                driver.findElement(By.xpath("//tbody/tr[ " + dm + " ]/td[4]/a[2]")).click();
                break;
            }
        }

    }
}
