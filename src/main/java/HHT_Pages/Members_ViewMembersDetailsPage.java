package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Members_ViewMembersDetailsPage {
    public static final Logger log = LogManager.getLogger(News_ViewNewsDetailsPage.class.getName());
    WebDriver driver;
    By ViewMembersHeaderBY = By.xpath("(//div[@id='bar']/h1)");


    public Members_ViewMembersDetailsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void viewMembers(String MemberName){
        List<WebElement> ViewMemberElements = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr//td[2]"));
        System.out.println(ViewMemberElements.size());
        for (int m = 0; m<ViewMemberElements.size(); m++)
        {
            String viewValue = ViewMemberElements.get(m).getText();
            if (viewValue.equals(MemberName))
            {
                int v = m + 2;
                driver.findElement(By.xpath("//tr[" + v + "]//td[4]//a[1]")).click();
                break;
            }
        }

    }

    public Boolean verifyViewMembersDetailsHeader(){
        return driver.findElement(ViewMembersHeaderBY).isDisplayed();
    }
}
