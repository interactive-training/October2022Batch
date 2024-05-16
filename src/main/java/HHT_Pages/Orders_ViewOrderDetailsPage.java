package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Orders_ViewOrderDetailsPage {
    public static final Logger log = LogManager.getLogger(News_ViewNewsDetailsPage.class.getName());
    WebDriver driver;

    By ViewOrdersDetailsHeaderBy = By.xpath("//div[@id='bar']//h1");
    public Orders_ViewOrderDetailsPage(WebDriver driver){
        this.driver = driver;
    }
    public void viewOrders(String OrderDate) {
        List<WebElement> viewOrdersdate = driver.findElements(By.xpath("//div[contains(@id,'purchase_list')]//table//tr//td[3]"));
        System.out.println(viewOrdersdate.size());
        for (int i = 0; i<viewOrdersdate.size(); i++)
        {
            String viewOrder = viewOrdersdate.get(i).getText();
            int j = i + 2;
            if (viewOrder.equals(OrderDate))
            {

                driver.findElement(By.xpath("//tr[" + j + "]//td[7]//a")).click();
                break;
            }
        }

    }
    public Boolean verifyViewOrdersDetailsHeader(){
        return driver.findElement(ViewOrdersDetailsHeaderBy).isDisplayed();
    }

}
