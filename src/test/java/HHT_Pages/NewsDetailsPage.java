package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsDetailsPage {
    public static final Logger log = LogManager.getLogger(NewsDetailsPage.class.getName());

    WebDriver driver;
    public NewsDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // By Variables

    public Boolean verifyNewsDetailsHeader(){
        return driver.findElement(By.xpath("//h1[text()='News Details']")).isDisplayed();
    }

    public void clickAddNews(){
        driver.findElement(By.linkText("Add News")).click();
    }

    // click View on NewsDetails Page
    public void clickViewNews(String NewsTitle){
        List<WebElement> ViewElements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println("Number of News Elements" + ViewElements.size());
//      driver.findElement(By.xpath("//tr[2]/td[4]/a[1]")).click();

//        if(ViewElements.contains(NewsTitle)){
//            int rows,columns;

        for (int i= 0; i<ViewElements.size(); i++) {

            String T = ViewElements.get(i).getText();

            if (T.equals(NewsTitle)) {
                int r=i+1;
                driver.findElement(By.xpath("//tr[" + r + "]/td[4]/a[1]")).click();
                break;
            }
        }
    }

    public void clickEditNews(String NewsTitle) {
        List<WebElement> EditElements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println(EditElements.size());

        for (int i1 = 0; i1 <= EditElements.size(); i1++) {
            String Title = EditElements.get(i1).getText();

            if (Title.equals(NewsTitle)) {
                int r1 = i1 + 2;
                driver.findElement(By.xpath("//tr[" + r1 + "]/td[4]/a[2]")).click();
                break;
            }
        }
    }
    public Boolean verifyNewsAlert(){
        return driver.findElement(By.xpath("//div[@class='error_msg']")).isDisplayed();
    }

    public void clickDeleteNews(String NewsTitle){
        List<WebElement> Elements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println(Elements.size());

        for (int i= 0; i<Elements.size(); i++) {

            String T = Elements.get(i).getText();

            if (T.equals(NewsTitle)) {
                int r=i+2;
                driver.findElement(By.xpath("//tr[" + r + "]/td[4]/a[3]")).click();
                break;
            }
        }
    }

}

